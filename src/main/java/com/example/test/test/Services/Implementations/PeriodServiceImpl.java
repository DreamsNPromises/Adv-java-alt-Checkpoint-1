package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.OverlappingPeriodsException;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Models.Entities.Slot;
import com.example.test.test.Repositories.EmployeeRepository;
import com.example.test.test.Repositories.PeriodRepository;
import com.example.test.test.Repositories.ScheduleRepository;
import com.example.test.test.Repositories.SlotRepository;
import com.example.test.test.Services.PeriodService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;
    @Autowired
    private SlotRepository slotRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Period createPeriod(Period period) throws NotFoundException, OverlappingPeriodsException {
        Slot slot = slotRepository.findById(period.getSlot().getId())
                .orElseThrow(() -> new NotFoundException("Slot with id " + period.getSlot().getId() + " not exist"));

        Schedule schedule = scheduleRepository.findById(period.getSchedule().getId())
                .orElseThrow(() -> new NotFoundException("Schedule with id " + period.getSchedule().getId() + " not exist"));

        Employee administrator = employeeRepository.findById(period.getAdministrator().getId())
                .orElseThrow(() -> new NotFoundException("Administrator with id " + period.getAdministrator().getId() + " not exist"));

        if (period.getExecutor() != null) {
            Employee executor = employeeRepository.findById(period.getExecutor().getId())
                    .orElseThrow(() -> new NotFoundException("Executor with id " + period.getExecutor().getId() + " not exist"));
            period.setExecutor(executor);
        }
        else {
            period.setExecutor(administrator);
        }

        period.setSlot(slot);
        period.setSchedule(schedule);
        period.setAdministrator(administrator);

        Slot periodSlot = period.getSlot();

        if (hasOverlappingPeriods(periodSlot, periodSlot.getBeginTime(), periodSlot.getEndTime())) {
            throw new OverlappingPeriodsException("Перекрывающиеся периоды недопустимы.");
        }

        return periodRepository.save(period);
    }

    @Override
    public Period getById(String id) throws NotFoundException {
        Optional<Period> period = periodRepository.findById(id);

        if(period.isPresent()){
            return period.get();
        }else{
            throw new NotFoundException("Period not found with id : " + id);
        }
    }

    @Override
    public Page<Period> getAll(Specification<Period> specification, PageRequest pageRequest) {
        return periodRepository.findAll(specification, pageRequest);
    }

    public Specification<Period> buildSpecification(PeriodFilter filter) {
        Specification<Period> specification = Specification.where(null);

        var specificationPredicates = new ArrayList<Specification<Period>>();

        if (filter != null) {
            if (filter.getId() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("id"), filter.getId()));
            }
            if (filter.getSlotId() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("slot").get("id"), filter.getSlotId()));
            }
            if (filter.getScheduleId() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("schedule").get("id"), filter.getScheduleId()));
            }
            if (filter.getSlotType() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("slotType"), filter.getSlotType()));
            }
            if (filter.getAdministratorId() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("administrator").get("id"), filter.getAdministratorId()));
            }
            if (filter.getExecutorId() != null) {
                specificationPredicates.add((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("executor").get("id"), filter.getExecutorId()));
            }
        }

        return Specification.allOf(specificationPredicates);
    }

    @Transactional
    public void checkOverlapping(Period period) throws OverlappingPeriodsException {
        Employee executor = period.getExecutor();
        Schedule schedule = period.getSchedule();

        List<Period> existingPeriods = periodRepository.findAllByExecutorAndSchedule(executor, schedule);

        for (Period existingPeriod : existingPeriods) {
            if (period.getId() == null || !period.getId().equals(existingPeriod.getId())) {
                if (isOverlapping(period, existingPeriod)) {
                    throw new OverlappingPeriodsException("New period overlaps with existing one");
                }
            }
        }
    }

    private boolean isOverlapping(Period period1, Period period2) {
        LocalTime startTime1 = period1.getSlot().getBeginTime();
        LocalTime endTime1 = period1.getSlot().getEndTime();
        LocalTime startTime2 = period2.getSlot().getBeginTime();
        LocalTime endTime2 = period2.getSlot().getEndTime();

        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }

    public boolean hasOverlappingPeriods(Slot slot, LocalTime startTime, LocalTime endTime) {

        List<Period> periods = periodRepository.findBySlot(slot);

        for (Period period : periods) {
            if (period.getSlot().getEndTime().isAfter(startTime) && period.getSlot().getBeginTime().isBefore(endTime)) {
                return true;
            }
        }

        return false;
    }

}
