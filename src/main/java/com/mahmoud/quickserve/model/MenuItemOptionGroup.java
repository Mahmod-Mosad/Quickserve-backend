package com.mahmoud.quickserve.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MenuItemOptionGroup {
    @Id
    @GeneratedValue
    private Long menuItemOptionGroupId;
    @Column(nullable = false)
    private String menuItemOptionGroupName;
    @Column(nullable = false)
    private Boolean required;
    @Column(nullable = false)
    private Boolean multipleChoice;
     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "menuItemId")
    private MenuItem menuItem;

     @OneToMany(mappedBy = "menuItemOptionGroup")
    private List<MenuItemOptionValue>  menuItemOptionValues;

}
