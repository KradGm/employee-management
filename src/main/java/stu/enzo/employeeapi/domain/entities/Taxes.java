package stu.enzo.employeeapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="taxes")
@Table(name="taxes")
public class Taxes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    double taxRate;
    public double calculateIRR(double salary){
        return salary* 0.15;
    }
    public double calculateFGTS(double salario) {
        return salario * 0.08;
    }
    public double calculateRAT(double salary,boolean isRisky){
        if(isRisky){
            return salary * 0.02;
        }
        return salary * 0;
    }
    public double calculateTotal(double salary, boolean isRisky){
        return calculateIRR(salary) + calculateFGTS(salary) + calculateRAT(salary, isRisky);
    }
}
