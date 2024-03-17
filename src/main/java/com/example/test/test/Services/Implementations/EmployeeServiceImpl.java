package com.example.test.test.Services.Implementations;

import com.example.test.test.Models.DTOs.PeriodFilter;
import com.example.test.test.Models.DTOs.PeriodSort;
import com.example.test.test.Models.Entities.Employee;
import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.Models.Entities.Period;
import com.example.test.test.Repositories.EmployeeRepository;
import com.example.test.test.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(String id) throws NotFoundException {
        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new NotFoundException("Employee not found with id : " + id);
        }
    }

}