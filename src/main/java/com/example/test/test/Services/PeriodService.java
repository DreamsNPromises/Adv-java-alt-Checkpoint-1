package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.OverlappingPeriodsException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.ScheduleTemplate;
import com.example.test.test.Models.Entities.Slot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public interface PeriodService {

    Period createPeriod(Period period) throws NotFoundException, OverlappingPeriodsException;

    Period getById(String id) throws NotFoundException;

    Page<Period> getAll(Specification<Period> specification, PageRequest pageRequest);

}