package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Restaurants")
public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String   address;
    @Column(nullable = false)
    private String   phone;
    @Column(nullable = false)
    private Double   longitude	;
    @Column(nullable = false)
    private Double  latitude;
    @Column(nullable = false)
    private String   workingHours;
    @Column(nullable = false)
    private Boolean manualOverride;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;






}
