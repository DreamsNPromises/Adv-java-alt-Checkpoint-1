package com.example.test.test.Services;

import com.example.test.test.Entities.Period;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface PeriodService {

    Period createPeriod(Period period);

//    List<Period> getPeriods(PeriodFilter filter, Sort sort, Pageable pageable);

    void checkOverlapping();
}