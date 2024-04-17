package stu.enzo.employeeapi.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import stu.enzo.employeeapi.domain.entities.Taxes;

import java.util.List;

public interface TaxesRepository extends JpaRepository<Taxes, Integer> {
    List<Taxes> findByTaxRate(double taxRate);
}
