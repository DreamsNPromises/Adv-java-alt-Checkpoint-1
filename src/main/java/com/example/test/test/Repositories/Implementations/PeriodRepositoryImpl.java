package com.example.test.test.Repositories.Implementations;

import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Repositories.PeriodRepository;
import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodSort;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;

public class PeriodRepositoryImpl implements PeriodRepository {

    @Override
    public Page<Period> findAll(
//            @Nullable PeriodFilter filter,
//            @Nullable PeriodSort sort,
            @PageableDefault(size = 20) Pageable pageable
    ) {

    }
}
