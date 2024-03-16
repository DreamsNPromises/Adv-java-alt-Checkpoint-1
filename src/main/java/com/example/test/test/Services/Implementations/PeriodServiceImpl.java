package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodSort;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Models.Entities.Slot;
import com.example.test.test.Repositories.PeriodRepository;
import com.example.test.test.Repositories.SlotRepository;
import com.example.test.test.Services.PeriodService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodRepository periodRepository;

    @Override
    public Period createPeriod(Period period) {
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
    public Page<Period> getAll(Specification<Period> specification, Pageable pageable) {
        return periodRepository.findAll(specification, pageable);
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

/*    @Transactional
    public void checkOverlapping(Period period) {
        Schedule schedule = period.getSchedule();
        List<Period> existingPeriods = periodRepository.findAllBySchedule(schedule);
        for (Period existingPeriod : existingPeriods) {
            if (period.getId() == null || !period.getId().equals(existingPeriod.getId())) {
                if (isOverlapping(period, existingPeriod)) {
                    throw new OverlappingPeriodException("New period overlaps with existing one");
                }
            }
        }
    }

    private boolean isOverlapping(Period period1, Period period2) {
        LocalTime startTime1 = period1.getBeginTime();
        LocalTime endTime1 = period1.getEndTime();
        LocalTime startTime2 = period2.getBeginTime();
        LocalTime endTime2 = period2.getEndTime();

        return (startTime1.isBefore(endTime2) && endTime1.isAfter(startTime2));
    }*/

//    public Sort buildSort(PeriodSort sort) {
//
//        Sort sortBuilder = Sort.unsorted();
//
//        if (sort != null) {
//            sortBuilder = sortBuilder.by(sort.getDirection().name()).on(sort.getField().name());
//        }
//
//        return sortBuilder;
//    }

}
