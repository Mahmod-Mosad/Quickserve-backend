package com.mahmoud.quickserve.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class BrandWallet {

    @Id
    @GeneratedValue
    private Long brandWalletId;
    @Column(nullable = false)
    private BigDecimal balance;


    @OneToOne
    @JoinColumn(name = "brandId", unique = true)
    private Brand brand;

    @OneToMany(mappedBy = "brandWallet")
    @JsonIgnore
    private List<WalletTransaction> transactions = new ArrayList<>();

}
