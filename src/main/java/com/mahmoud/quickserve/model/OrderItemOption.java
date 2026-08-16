package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class OrderItemOption {
    @Id
    @GeneratedValue
    private Long orderItemOptionId;
    @Column(nullable = false)
    private String optionValueName;
    @Column(nullable = false)
    private BigDecimal extraPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItemId")
    private OrderItem orderItem;


}
