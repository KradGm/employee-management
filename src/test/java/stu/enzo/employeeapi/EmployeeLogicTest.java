package stu.enzo.employeeapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.entities.Taxes;
import stu.enzo.employeeapi.domain.enums.RatLevel;
@SpringBootTest
public class EmployeeLogicTest {
    @Test
    public void testCalculateTotalTaxes(){
        Employee employee = new Employee(1,"Erick","dev",3000, RatLevel.NO_RAT);
        Employee employeeLowRat = new Employee(1,"Erick","dev",3000, RatLevel.LOW_LEVEL);
        Employee employeeMediumRat = new Employee(1,"Erick","dev",3000, RatLevel.MEDIUM_LEVEL);
        Employee employeeHighRat = new Employee(1,"Erick","dev",3000, RatLevel.HIGH_LEVEL);
        Taxes tax = new Taxes();
        Assertions.assertEquals(2310,employee.getSalary() - tax.calculateTotal(employee.getSalary(),employee.getRatLevel()));
        Assertions.assertEquals(2250,employeeLowRat.getSalary() - tax.calculateTotal(employeeLowRat.getSalary(),employeeLowRat.getRatLevel()));
        Assertions.assertEquals(2160,employeeMediumRat.getSalary() - tax.calculateTotal(employeeMediumRat.getSalary(),employeeMediumRat.getRatLevel()));
        Assertions.assertEquals(2280,employeeHighRat.getSalary() - tax.calculateTotal(employeeHighRat.getSalary(),employeeHighRat.getRatLevel()));;
    }
}
