package com.example.test.test.Controllers;

import com.example.test.test.Entities.Employee;
import com.example.test.test.ExceptionsHandling.Exceptions.NotFoundException;
import com.example.test.test.ServicesImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

/*    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id) {
        Optional<Employee> employeeOptional = employeeService.getById(id);
        if (employeeOptional.isPresent()) {
            return ResponseEntity.ok(employeeOptional.get()); // Возвращаем сотрудника в ответе с кодом 200 OK
        } else {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("error", "Сотрудник с таким id не найден...");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseBody); // Если сотрудник не найден, возвращаем код 404 Not Found с сообщением
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(employeeService.getById(id));
/*        if (employeeOptional.isPresent()) {
            return ResponseEntity.ok(employeeOptional.get()); // Возвращаем сотрудника в ответе с кодом 200 OK
        } else {
            return ResponseEntity.notFound().build(); // Если сотрудник не найден, возвращаем код 404 Not Found
        }*/
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody @Validated Employee employee) {
        return employeeService.createEmployee(employee);
    }

}