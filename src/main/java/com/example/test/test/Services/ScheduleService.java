package com.example.test.test.Services;

import com.example.test.test.Entities.Schedule;

import java.util.UUID;

public interface ScheduleService {

    Schedule createSchedule(Schedule schedule);

    Schedule getScheduleById(UUID id);

    Schedule getScheduleByName(String name);

    //List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

}