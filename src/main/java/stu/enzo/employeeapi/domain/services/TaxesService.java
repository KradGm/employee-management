package stu.enzo.employeeapi.domain.services;

import stu.enzo.employeeapi.domain.entities.Taxes;

import java.util.List;
import java.util.Optional;

public interface TaxesService {
    Optional<Taxes> getTaxById(int id);
    List<Taxes> findTaxesByTaxRate(double taxRate);
}
