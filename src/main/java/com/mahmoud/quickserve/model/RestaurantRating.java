package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class RestaurantRating {
    @Id
    @GeneratedValue
    private Long restaurantRatingId;
     @Column(nullable = false)
    private Integer rating;
    private String comment;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "orderId", unique = true,nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" ,nullable = false)
    private User customer;


}
