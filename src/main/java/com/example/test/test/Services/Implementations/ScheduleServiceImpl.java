package com.example.test.test.Services.Implementations;

import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Repositories.PeriodRepository;
import com.example.test.test.Repositories.ScheduleRepository;
import com.example.test.test.Services.ScheduleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Override
    @Transactional
    public Schedule createSchedule(Schedule schedule) {
        schedule.setCreationDate(LocalDateTime.now());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        // ... (logic to create templates and slots)
        return savedSchedule;
    }

    @Override
    public Schedule getScheduleById(String id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        return optionalSchedule.orElse(null);
    }

//    @Override
//    public List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable) {
//        return periodRepository.findAll(filter, sort, pageable);
//    }

    // ... (implement methods for creating templates and slots)

}