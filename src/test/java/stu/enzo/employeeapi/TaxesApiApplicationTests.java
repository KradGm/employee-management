package stu.enzo.employeeapi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import stu.enzo.employeeapi.domain.entities.Employee;
import stu.enzo.employeeapi.domain.entities.Taxes;
import stu.enzo.employeeapi.domain.services.TaxesService;
import stu.enzo.employeeapi.domain.services.implementation.TaxesServiceImpl;
import stu.enzo.employeeapi.infrastructure.repositories.TaxesRepository;

import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TaxesApiApplicationTests {
    @InjectMocks
    TaxesServiceImpl service;
    @Mock
    TaxesRepository repository;
    @Test
    public void createNewTax() {
        Taxes tax = new Taxes();
        service.save(tax);
        verify(repository).save(tax);
        verifyNoMoreInteractions(repository);
    }
    @Test
    public void testSaveTax() {
        Taxes tax = new Taxes();
        tax.setTaxRate(0.15);
        when(repository.save(any(Taxes.class))).thenReturn(tax);
        service.save(tax);

        verify(repository, times(1)).save(tax);
    }
    @Test
    public void getTaxById() {
        Taxes existingTax = new Taxes(1,2);
        when(repository.findById(existingTax.getId())).thenReturn(Optional.of(existingTax));
        service.getTaxById(existingTax.getId());
        verify(repository, times(1)).findById(existingTax.getId());
        verifyNoMoreInteractions(repository);
        Assertions.assertEquals(existingTax.getId(),1);
        Assertions.assertEquals(existingTax.getTaxRate(), 2);
    }
    @Test
    public void getTaxByTaxRate(){
        Taxes existingTax = new Taxes(1,2);

    }
}
