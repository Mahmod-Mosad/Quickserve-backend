package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MenuItemOptionValue {
    @Id
    @GeneratedValue
    private Long menuItemOptionValueId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal extraPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menuItemOptionGroupId")
    private MenuItemOptionGroup menuItemOptionGroup;


}
