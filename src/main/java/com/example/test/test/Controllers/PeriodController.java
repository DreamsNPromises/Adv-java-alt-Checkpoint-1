package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.ScheduleTemplate;
import com.example.test.test.Services.Implementations.PeriodServiceImpl;
import com.example.test.test.Services.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/period")
public class PeriodController {

    @Autowired
    private PeriodServiceImpl periodService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Period createPeriod(@RequestBody @Validated Period period) {
        return periodService.createPeriod(period);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Period> getPeriodById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(periodService.getById(id));
    }

}