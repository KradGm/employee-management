package stu.enzo.employeeapi.domain.services;

import stu.enzo.employeeapi.domain.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployeeById(long id);
    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByName(String firstName, String lastName);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(long id);
    public Employee getEmployeeByRole(String role);


}
