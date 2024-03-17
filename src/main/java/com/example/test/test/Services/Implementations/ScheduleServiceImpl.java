package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Models.Entities.ScheduleTemplate;
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

        return savedSchedule;
    }

    @Override
    public Schedule getScheduleById(String id) throws NotFoundException {
        Optional<Schedule> schedule = scheduleRepository.findById(id);

        if(schedule.isPresent()){
            return schedule.get();
        }else{
            throw new NotFoundException("Schedule not found with id : " + id);
        }
    }

}