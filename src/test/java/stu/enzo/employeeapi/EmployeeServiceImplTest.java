package stu.enzo.employeeapi;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.services.implementation.EmployeeServiceImpl;
import stu.enzo.employeeapi.infrastructure.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void getAllEmployees() {
        // Mocking
        List<Employee> mockEmployees = Instancio.stream(Employee.class).limit(10).toList();
        when(employeeRepository.findAll()).thenReturn(mockEmployees);

        // Test
        List<Employee> result = employeeService.getAllEmployees();

        // Verification
        assertEquals(mockEmployees, result);
        verify(employeeRepository).findAll();
    }

    @Test
    void getEmployeeById_ExistingEmployee() {
        // Mocking
        long employeeId = 1L;
        Employee mockEmployee = new Employee();
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        // Test
        Optional<Employee> result = employeeService.getEmployeeById(employeeId);

        // Verification
        assertEquals(Optional.of(mockEmployee), result);
        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    void getEmployeeById_NonExistingEmployee() {
        // Mocking
        long employeeId = 1L;
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        // Test and Verification
        assertEquals(Optional.empty(), employeeService.getEmployeeById(employeeId));
        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    void addEmployee() {
        // Mocking
        Employee mockEmployee = new Employee();
        when(employeeRepository.save(mockEmployee)).thenReturn(mockEmployee);

        // Test
        Employee result = employeeService.addEmployee(mockEmployee);

        // Verification
        assertEquals(mockEmployee, result);
        verify(employeeRepository).save(mockEmployee);
    }

    @Test
    void updateEmployee_ExistingEmployee() {
        // Mocking
        long employeeId = 1L;
        Employee existingEmployee = new Employee();
        existingEmployee.setId(employeeId);
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(existingEmployee));

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(employeeId);
        updatedEmployee.setName("New Name");

        // Test
        Employee result = employeeService.updateEmployee(updatedEmployee);

        // Verification
        assertEquals(updatedEmployee.getName(), existingEmployee.getName());
        verify(employeeRepository).save(existingEmployee);
    }

    @Test
    void updateEmployee_NonExistingEmployee() {
        // Mocking
        long nonExistingEmployeeId = 1L;
        Employee nonExistingEmployee = new Employee();
        nonExistingEmployee.setId(nonExistingEmployeeId);

        when(employeeRepository.findById(nonExistingEmployeeId)).thenReturn(Optional.empty());

        // Test and Verification
        assertThrows(RuntimeException.class, () -> employeeService.updateEmployee(nonExistingEmployee));
        verify(employeeRepository).findById(nonExistingEmployeeId);
    }

    @Test
    void deleteEmployee() {
        // Mocking
        long employeeId = 1L;

        // Test
        employeeService.deleteEmployee(employeeId);

        // Verification
        verify(employeeRepository).deleteById(employeeId);
    }
}
