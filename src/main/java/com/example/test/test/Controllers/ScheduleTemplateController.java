package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.Models.Entities.ScheduleTemplate;
import com.example.test.test.Repositories.ScheduleTemplateRepository;
import com.example.test.test.Services.Implementations.EmployeeServiceImpl;
import com.example.test.test.Services.Implementations.ScheduleTemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/scheduleTemplate")
public class ScheduleTemplateController {

    @Autowired
    private ScheduleTemplateServiceImpl scheduleTemplateService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleTemplate createTemplate(@RequestBody ScheduleTemplate scheduleTemplate) {
        return scheduleTemplateService.createTemplate(scheduleTemplate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleTemplate> getTemplateById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(scheduleTemplateService.getById(id));
    }

}
