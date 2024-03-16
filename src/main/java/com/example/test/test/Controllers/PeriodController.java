package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodSort;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Enums.SlotType;
import com.example.test.test.Services.Implementations.PeriodServiceImpl;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
            @RequestParam(name = "filter.id", required = false) String id,
            @RequestParam(name = "filter.slotId", required = false) String slotId,
            @RequestParam(name = "filter.scheduleId", required = false) String scheduleId,
            @RequestParam(name = "filter.slotType", required = false) String slotType,
            @RequestParam(name = "filter.administratorId", required = false) String administratorId,
            @RequestParam(name = "filter.executorId", required = false) String executorId,
            @Nullable PeriodSort sort,
            @PageableDefault(size = 20) Pageable pageable
    ) throws NotFoundException {
        PeriodFilter filter = new PeriodFilter();

        filter.setId(id);
        filter.setSlotId(slotId);
        filter.setScheduleId(scheduleId);
        filter.setSlotType(SlotType.validateSlotType(slotType));
        filter.setAdministratorId(administratorId);
        filter.setExecutorId(executorId);


        Specification<Period> specification = periodService.buildSpecification(filter);

        Page<Period> page = periodService.getAll(specification, pageable);

        return ResponseEntity.ok(page);
    }

}