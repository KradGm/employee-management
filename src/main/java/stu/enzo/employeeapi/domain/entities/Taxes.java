package stu.enzo.employeeapi.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stu.enzo.employeeapi.domain.enums.RatLevel;

@Getter
@Setter
@NoArgsConstructor
public class Taxes{
    // Tax rates
    private static final double IRR_RATE = 0.15;
    private static final double FGTS_RATE = 0.08;
    private static final double RAT_LOW_LEVEL_RATE = 0.02;
    private static final double RAT_HIGH_LEVEL_RATE = 0.01;
    private static final double RAT_MEDIUM_LEVEL_RATE = 0.05;

    // Calculate IRR
    public double calculateIRR(double salary){
        if(salary <= 2259.20){
            return 0;
        } else if(salary <= 2826.65){
            return salary * 0.075;
        } else if(salary <= 3751.05){
            return salary * 0.15;
        } else if(salary <= 4664.68){
            return salary * 0.225;
        } else {
            return salary * 0.275;
        }
    }

    // Calculate FGTS
    public double calculateFGTS(double salary) {
        return salary * FGTS_RATE;
    }

    // Calculate RAT based on the level
    public double calculateRAT(double salary, RatLevel ratLevel) {
        return switch (ratLevel) {
            case LOW_LEVEL -> salary * RAT_LOW_LEVEL_RATE;
            case HIGH_LEVEL -> salary * RAT_HIGH_LEVEL_RATE;
            case MEDIUM_LEVEL -> salary * RAT_MEDIUM_LEVEL_RATE;
            case NO_RAT -> salary * 0;
            default -> throw new IllegalArgumentException("Invalid RAT Level");
        };
    }

    // Calculate total taxes
    public double calculateTotal(double salary, RatLevel ratLevel){
        return calculateIRR(salary) + calculateFGTS(salary) + calculateRAT(salary, ratLevel);
    }
}