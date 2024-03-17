package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Schedule;

public interface ScheduleService {

    Schedule createSchedule(Schedule schedule);

    Schedule getScheduleById(String id) throws NotFoundException;

    Schedule getScheduleByName(String name) throws NotFoundException;
}