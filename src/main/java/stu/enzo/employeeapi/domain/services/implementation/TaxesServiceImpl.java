package stu.enzo.employeeapi.domain.services.implementation;

import org.springframework.stereotype.Service;
import stu.enzo.employeeapi.domain.entities.Taxes;
import stu.enzo.employeeapi.domain.services.TaxesService;
import stu.enzo.employeeapi.infrastructure.repositories.TaxesRepository;

import java.util.List;
import java.util.Optional;
@Service
public class TaxesServiceImpl implements TaxesService {
    TaxesRepository taxesRepository;
    TaxesServiceImpl(TaxesRepository taxesRepository) {
        this.taxesRepository = taxesRepository;
    }
    public void save(Taxes tax) {
        taxesRepository.save(tax);
    }

    public Optional<Taxes> getTaxById(int id) {
        return taxesRepository.findById(id);
    }

    public List<Taxes> findTaxesByTaxRate(double taxRate) {
        return taxesRepository.findByTaxRate(taxRate);
    }
}
