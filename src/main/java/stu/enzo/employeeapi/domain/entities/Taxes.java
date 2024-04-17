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

}
