package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PayrollSettings {
    @Id
    @GeneratedValue
    private Long payrollSettingsId;
     @Enumerated(EnumType.STRING)
     @Column(nullable = false,unique = true)
    private VehicleType vehicleType;
     @Column(nullable = false)
     private Integer minimumTrips ;
     @Column(nullable = false)
     private BigDecimal baseSalary ;
     @Column(nullable = false)
     private BigDecimal perExtraTripBonus ;

}
