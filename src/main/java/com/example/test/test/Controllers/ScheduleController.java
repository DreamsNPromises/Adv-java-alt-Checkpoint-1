package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleService.createSchedule(schedule);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

}