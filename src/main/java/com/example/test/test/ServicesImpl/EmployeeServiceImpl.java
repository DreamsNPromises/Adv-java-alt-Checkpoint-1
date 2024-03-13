package com.example.test.test.ServicesImpl;

import com.example.test.test.Entities.Employee;
import com.example.test.test.Repositories.EmployeeRepository;
import com.example.test.test.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
//        if (!EnumUtils.isValidEnum(EmployeeStatus.class, employee.getStatus().name())) {
//            throw new InvalidEmployeeStatusException("Invalid employee status: " + employee.getStatus());
//        }
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(UUID id) {
        return employeeRepository.findById(id);
    }

}