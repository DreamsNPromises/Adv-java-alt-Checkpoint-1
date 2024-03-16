package com.example.test.test.Repositories;

import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.DTOs.PeriodSort;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {

    public Page<Period> findAll(
            @PageableDefault(size = 20) Pageable pageable
    );

    //List<Period> findAll(PeriodFilter filter, SortField sort, Pageable pageable);
}