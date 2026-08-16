package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue
    private Integer deliveryId;
    private LocalDateTime pickupAt;
    private LocalDateTime deliveredAt;
      @Enumerated(EnumType.STRING)
      @Column(nullable = false)
    private DeliveryStatus deliveryStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private User driver;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;





}
