package stu.enzo.employeeapi;

import jakarta.inject.Inject;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.services.EmployeeService;
import stu.enzo.employeeapi.domain.services.implementation.EmployeeServiceImpl;
import stu.enzo.employeeapi.infrastructure.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeApiApplicationTests {
    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Mock
    EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
        Employee e = new Employee(1,"Enzo", "Dev",2000.0);
        assertEquals(e.id(),1);
    }

    @Test
    void getAllEmployee() {
        Employee e = new Employee(1,"Enzo", "Dev",2000.0);
        employeeService.getAllEmployees();
        verify(employeeRepository).findAll();
        verifyNoMoreInteractions(employeeRepository);verifyNoInteractions();

    }


}
