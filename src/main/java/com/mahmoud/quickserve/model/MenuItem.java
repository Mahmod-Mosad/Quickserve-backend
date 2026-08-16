package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue
    private long menuItemId;
    @Column(nullable = false)
    private String menuItemName;
    private String menuItemDescription;
    @Column(nullable = false)
    private String menuItemIconUrl;
    @Column(nullable = false)
    private BigDecimal menuItemPrice;
    @Column(nullable = false)
    private Boolean available;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "categoryId")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brandId")
    private Brand brand;
    @OneToMany(mappedBy = "menuItem")
    private List<MenuItemOptionGroup>  menuItemOptionGroups;



}
