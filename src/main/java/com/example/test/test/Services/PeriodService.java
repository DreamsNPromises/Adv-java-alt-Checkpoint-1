package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.ScheduleTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PeriodService {

    Period createPeriod(Period period);

    Period getById(UUID id) throws NotFoundException;

    Page<Period> getAll(Pageable pageable);

//    List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

//    void checkOverlapping();
}