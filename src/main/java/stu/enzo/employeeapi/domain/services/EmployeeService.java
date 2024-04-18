package stu.enzo.employeeapi.domain.services;

import stu.enzo.employeeapi.domain.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<Employee> getEmployeeById(long id);
    public List<Employee> getAllEmployees();
    public Optional<Employee> getEmployeesByName(String name);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public Employee getEmployeeByRole(String role);
    public double calculateNetSalary(Employee employee);

}
