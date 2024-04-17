package stu.enzo.employeeapi.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.enzo.employeeapi.domain.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByNameIgnoreCase( String name );

    Employee findByRole(String role);
}
