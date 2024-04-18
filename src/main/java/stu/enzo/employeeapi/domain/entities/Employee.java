package stu.enzo.employeeapi.domain.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity(name = "employee")
@EqualsAndHashCode(of = "id")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String role;
    private double salary;
    @Column(name = "tax_rate")
    private double taxRate;


}
