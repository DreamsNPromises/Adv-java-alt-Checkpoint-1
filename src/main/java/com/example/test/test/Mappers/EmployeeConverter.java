package com.example.test.test.Mappers;

import com.example.test.test.Models.DTOs.EmployeeDTO;
import com.example.test.test.Models.Entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeConverter {

    @Autowired
    private ModelMapper modelMapper;
    public EmployeeDTO employeeToDTO(Employee employee){
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

        return employeeDTO;
    }

    public Employee employeeFromDTO(EmployeeDTO employeeDTO){
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        return employee;
    }
}
