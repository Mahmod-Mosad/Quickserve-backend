package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class DriverTripCounter {

    @Id
    @GeneratedValue
    private Long driverTripCounterId;
    @Column(nullable = false)
    private Integer currentTripCount;

    @OneToOne
    @JoinColumn(name = "userId" ,unique = true)
    private User user;


}
