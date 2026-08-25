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
public class Wallet {

    @Id
    @GeneratedValue
    private Long walletId;
    @Column(nullable = false)
    private BigDecimal balance;

   @OneToOne
   @JoinColumn(name = "userId" ,unique = true)
    private User user ;

    @OneToMany(mappedBy = "wallet")
    @JsonIgnore
    private List<WalletTransaction> transactions = new ArrayList<>();

}
