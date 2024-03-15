package com.example.test.test.Services;

import com.example.test.test.Entities.Employee;
import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getById(UUID id) throws NotFoundException;
}
