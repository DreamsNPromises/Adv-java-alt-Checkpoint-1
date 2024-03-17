package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Schedule;

import java.util.UUID;

public interface ScheduleService {

    Schedule createSchedule(Schedule schedule);

    Schedule getScheduleById(String id) throws NotFoundException;

    //List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

}