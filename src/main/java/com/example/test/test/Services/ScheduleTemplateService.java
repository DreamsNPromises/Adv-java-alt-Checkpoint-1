package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.Models.Entities.ScheduleTemplate;

import java.util.UUID;

public interface ScheduleTemplateService {

    ScheduleTemplate createTemplate(ScheduleTemplate scheduleTemplate);

    ScheduleTemplate getById(String id) throws NotFoundException;
}
