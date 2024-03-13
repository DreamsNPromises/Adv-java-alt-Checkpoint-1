package com.example.test.test.Services;

import com.example.test.test.Entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAll();
}
