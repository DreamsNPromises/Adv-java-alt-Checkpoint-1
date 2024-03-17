package com.example.test.test.Repositories;

import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Models.Entities.Schedule;
import com.example.test.test.Models.Entities.Slot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PeriodRepository extends JpaRepository<Period, String>, JpaSpecificationExecutor<Period> {

    Page<Period> findAll(Specification<Period> specification, Pageable pageable);

    List<Period> findAllByExecutorAndSchedule(Employee executor, Schedule schedule);

    List<Period> findBySlot(Slot slot);
}