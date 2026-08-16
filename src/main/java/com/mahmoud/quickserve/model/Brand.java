package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    @Column(nullable = false)
    private String brandName;
    private String description;
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING_APPROVAL;
    @Column(nullable = false)
    private BigDecimal commissionRate;
    @OneToMany(mappedBy = "brand")
    private List<Restaurant>  restaurants;

}
