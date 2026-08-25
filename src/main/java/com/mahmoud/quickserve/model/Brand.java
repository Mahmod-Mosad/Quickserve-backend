package com.mahmoud.quickserve.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue
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
    @JsonIgnore
    private List<Restaurant>  restaurants;
    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Category> categories ;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<MenuItem>  menuItems;

    @OneToOne(mappedBy = "brand")
    @JsonIgnore
    private BrandWallet brandWallet;

}
