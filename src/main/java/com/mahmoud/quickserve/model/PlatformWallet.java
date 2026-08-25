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
public class PlatformWallet {

    @Id
    @GeneratedValue
    private Long platformWalletId;

    @Column(nullable = false)
    private BigDecimal balance;

}