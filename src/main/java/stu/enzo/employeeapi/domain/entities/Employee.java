package stu.enzo.employeeapi.domain.entities;


import jakarta.persistence.*;

@Entity(name = "employee")
public record Employee(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
         long id,

         String name,

         String role,

         double salary
) {
}
