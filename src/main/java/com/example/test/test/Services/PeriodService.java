package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.ScheduleTemplate;

import java.util.UUID;

public interface PeriodService {

    Period createPeriod(Period period);

    Period getById(UUID id) throws NotFoundException;

//    List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

//    void checkOverlapping();
}