package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.ScheduleTemplate;

public interface ScheduleTemplateService {

    ScheduleTemplate createTemplate(ScheduleTemplate scheduleTemplate);

    ScheduleTemplate getById(String id) throws NotFoundException;
}
