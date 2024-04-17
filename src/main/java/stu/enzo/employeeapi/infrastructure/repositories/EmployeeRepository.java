package stu.enzo.employeeapi.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.enzo.employeeapi.domain.entities.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
