package com.example.test.test.Services;

import com.example.test.test.Entities.Employee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Optional<Employee> getById(UUID id);
}
