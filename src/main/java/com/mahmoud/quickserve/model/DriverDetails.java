package com.mahmoud.quickserve.model;

import com.mahmoud.quickserve.model.enums.ApprovalStatus;
import com.mahmoud.quickserve.model.enums.Status;
import com.mahmoud.quickserve.model.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "driver_details")
public class DriverDetails {

    @Id
    private Long userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;
}