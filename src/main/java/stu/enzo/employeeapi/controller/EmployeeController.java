package stu.enzo.employeeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.services.EmployeeService;
import stu.enzo.employeeapi.infrastructure.repositories.EmployeeRepository;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

}
