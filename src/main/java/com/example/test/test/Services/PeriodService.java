package com.example.test.test.Services;

import com.example.test.test.Models.Entities.Period;

public interface PeriodService {

    Period createPeriod(Period period);

//    List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

    void checkOverlapping();
}