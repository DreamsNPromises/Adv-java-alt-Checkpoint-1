package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Services.Implementations.PeriodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class PeriodController {

    @Autowired
    private PeriodServiceImpl periodService;

    @PostMapping("/period/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Period createPeriod(@RequestBody @Validated Period period) {
        return periodService.createPeriod(period);
    }

    @GetMapping("/period/{id}")
    public ResponseEntity<Period> getPeriodById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(periodService.getById(id));
    }

    @GetMapping("/periods")
    public ResponseEntity<Page<Period>> getPeriods(
            @PageableDefault(size = 20) Pageable pageable
    ) throws NotFoundException {
        return ResponseEntity.ok(periodService.getAll(pageable));
    }

}