package com.example.test.test.Controllers;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.OverlappingPeriodsException;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodsResponse;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Enums.SlotType;
import com.example.test.test.Models.Enums.SortDirection;
import com.example.test.test.Models.Enums.SortField;
import com.example.test.test.Services.Implementations.PeriodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class PeriodController {

    @Autowired
    private PeriodServiceImpl periodService;

    @PostMapping("/period/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Period createPeriod(@RequestBody @Validated Period period) throws NotFoundException, OverlappingPeriodsException {
        return periodService.createPeriod(period);
    }

    @GetMapping("/period/{id}")
    public ResponseEntity<Period> getPeriodById(@PathVariable String id) throws NotFoundException {
        return ResponseEntity.ok(periodService.getById(id));
    }

    @GetMapping("/periods")
    public ResponseEntity<PeriodsResponse> getPeriods(
            @RequestParam(name = "filter.id", required = false) String id,
            @RequestParam(name = "filter.slotId", required = false) String slotId,
            @RequestParam(name = "filter.scheduleId", required = false) String scheduleId,
            @RequestParam(name = "filter.slotType", required = false) String slotType,
            @RequestParam(name = "filter.administratorId", required = false) String administratorId,
            @RequestParam(name = "filter.executorId", required = false) String executorId,
            @RequestParam(name = "beginTime", required = false) LocalTime beginTime,
            @RequestParam(name = "endTime", required = false) LocalTime endTime,
            @RequestParam(name = "sort.field", required = false) SortField sortField,
            @RequestParam(name = "sort.direction", required = false) SortDirection sortDirection,
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

        if (beginTime != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("slot").get("beginTime"), beginTime));
        }
        if (endTime != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("slot").get("endTime"), endTime));
        }

        Sort sort = Sort.by(sortDirection == SortDirection.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, sortField.toString());

        Page<Period> page = periodService.getAll(specification, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()).withSort(sort));

        PeriodsResponse response = new PeriodsResponse(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements());

        return ResponseEntity.ok(response);
    }

}