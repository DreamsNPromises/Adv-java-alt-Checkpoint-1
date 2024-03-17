package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.NullRequestForSearch;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Schedule> getScheduleByIdorName(@RequestParam(required = false) String id,
                                                          @RequestParam(required = false) String name) throws NotFoundException, NullRequestForSearch {

        if (id != null) {
            return ResponseEntity.ok(scheduleService.getScheduleById(id));
        } else if (name != null) {
            return ResponseEntity.ok(scheduleService.getScheduleByName(name));
        } else {
            throw new NullRequestForSearch("Specify the schedule id or schedule name");
        }
    }


}