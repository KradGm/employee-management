package stu.enzo.employeeapi.domain.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.services.EmployeeService;
import stu.enzo.employeeapi.infrastructure.repositories.EmployeeRepository;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getReferenceById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeesByName(String firstName, String lastName) {
        return List.of();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(long id) {

    }

    @Override
    public Employee getEmployeeByRole(String role) {
        return null;
    }
}
