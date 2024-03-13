package com.example.test.test.Repositories;

import com.example.test.test.Entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {

    //List<Period> findAll(PeriodFilter filter, SortField sort, Pageable pageable);
}