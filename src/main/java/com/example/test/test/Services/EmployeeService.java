package com.example.test.test.Services;

import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;

import java.util.UUID;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getById(String id) throws NotFoundException;
}
