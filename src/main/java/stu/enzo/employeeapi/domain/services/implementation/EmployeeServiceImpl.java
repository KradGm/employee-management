package stu.enzo.employeeapi.domain.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.services.EmployeeService;
import stu.enzo.employeeapi.infrastructure.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employee.getId());
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setName(employee.getName());
            existingEmployee.setRole(employee.getRole());
            // Adicione outros campos que deseja permitir a atualização
            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("Funcionário não encontrado com o ID: " + employee.getId());
        }
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByRole(String role) {
        return employeeRepository.findByRole(role);
    }
}
