package com.example.test.test.Controllers;

import com.example.test.test.Entities.Employee;
import com.example.test.test.ServicesImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Validated Employee employee) {
        return employeeService.createEmployee(employee);
    }

}