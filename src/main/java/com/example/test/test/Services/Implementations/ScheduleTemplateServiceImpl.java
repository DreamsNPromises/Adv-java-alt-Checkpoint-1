package com.example.test.test.Services.Implementations;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.Models.Entities.ScheduleTemplate;
import com.example.test.test.Repositories.EmployeeRepository;
import com.example.test.test.Repositories.ScheduleTemplateRepository;
import com.example.test.test.Services.ScheduleTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ScheduleTemplateServiceImpl implements ScheduleTemplateService {

    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;

    @Override
    public ScheduleTemplate createTemplate(ScheduleTemplate scheduleTemplate) {
        return scheduleTemplateRepository.save(scheduleTemplate);
    }

    @Override
    public ScheduleTemplate getById(UUID id) throws NotFoundException {
        Optional<ScheduleTemplate> scheduleTemplate = scheduleTemplateRepository.findById(id);
        if(scheduleTemplate.isPresent()){
            return scheduleTemplate.get();
        }else{
            throw new NotFoundException("Schedule template not found with id : " + id);
        }
    }

}
