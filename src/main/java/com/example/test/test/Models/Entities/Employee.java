package com.example.test.test.Models.Entities;

import com.example.test.test.Models.Enums.EmployeePosition;
import com.example.test.test.Models.Enums.EmployeeStatus;
import com.example.test.test.Utils.UUIDConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
@Table(name = "employees")
public class Employee {

    @Id
    private String id;

    @PrePersist
    public void prePersist() {
        UUIDConverter uuidConverter = new UUIDConverter();
        //На практике это означает, что даже при генерации миллиардов UUID в секунду
        //вероятность коллизии остается настолько ничтожно малой, что ей можно пренебречь.
        this.id = uuidConverter.convertToDatabaseColumn(UUID.randomUUID());
    }

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    @Column(name = "position", nullable = false)
    private EmployeePosition position;
}