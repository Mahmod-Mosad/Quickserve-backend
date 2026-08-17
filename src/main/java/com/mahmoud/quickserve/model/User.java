package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.ApprovalStatus;
import com.mahmoud.quickserve.model.enums.Role;
import com.mahmoud.quickserve.model.enums.Status;
import com.mahmoud.quickserve.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long userId;
    @Column( nullable = false)
    private String userName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column( nullable = false)
    private String password;
    @Column( nullable = false)
    private String phone;
    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;
    private Boolean enabled = true;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    @OneToMany(mappedBy = "driver")
    private List<Delivery> deliveries;



}
