package com.example.test.test.Entities;

import com.example.test.test.Enums.EmployeePosition;
import com.example.test.test.Enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @Column(name = "position", nullable = false)
    private EmployeePosition position;
}