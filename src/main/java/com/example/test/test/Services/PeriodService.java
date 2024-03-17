package com.example.test.test.Services;

import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ExceptionsHandling.Exceptions.OverlappingPeriodsException;
import com.example.test.test.Models.Entities.Period;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

public interface PeriodService {

    Period createPeriod(Period period) throws NotFoundException, OverlappingPeriodsException;

    Period getById(String id) throws NotFoundException;

    Page<Period> getAll(Specification<Period> specification, PageRequest pageRequest);

}