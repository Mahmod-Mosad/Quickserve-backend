package com.mahmoud.quickserve.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantResponseDTO {
    private Long restaurantId;
    private String address;
    private Double latitude;
    private Double longitude;
    private String phone ;
    private String workingHours;
    private Boolean manualOverride ;
    private String brandName;


}
