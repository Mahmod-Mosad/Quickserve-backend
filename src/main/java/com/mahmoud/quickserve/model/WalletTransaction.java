package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.WalletTransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class WalletTransaction {

  @Id
  @GeneratedValue
  private Long walletTransactionId;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private WalletTransactionType walletTransactionType;
  @Column(nullable = false)
  private BigDecimal amount;
  @CreationTimestamp
  private LocalDateTime date;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "walletId")
    private Wallet wallet;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandWalletId")
    private BrandWallet brandWallet;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "platformWalletId")
    private PlatformWallet platformWallet;





}
