package com.mahmoud.quickserve.service;

import com.mahmoud.quickserve.DTO.RestaurantResponse;
import com.mahmoud.quickserve.model.Restaurant;
import com.mahmoud.quickserve.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private static final Double MAX_DISTANCE_KM = 10.0;


    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse convertToDTO(Restaurant restaurant) {
        RestaurantResponse dto = new RestaurantResponse();
        dto.setRestaurantId(restaurant.getRestaurantId());
        dto.setAddress(restaurant.getAddress());
        dto.setLatitude(restaurant.getLatitude());
        dto.setLongitude(restaurant.getLongitude());
        dto.setPhone(restaurant.getPhone());
        dto.setWorkingHours(restaurant.getWorkingHours());
        dto.setManualOverride(restaurant.getManualOverride());
        dto.setBrandName(restaurant.getBrand().getBrandName()); // ← بناخد بس الاسم من جوه الـ Brand
        return dto;
    }



     public List<RestaurantResponse>  getNearbyRestaurants(Double customerLat, Double customerLng) {

         List<Restaurant > restaurants= restaurantRepository.findNearbyRestaurants(customerLat,customerLng,MAX_DISTANCE_KM);
         List<RestaurantResponse> dtos = restaurants.stream()
                 .map(this::convertToDTO)
                 .toList();
         return dtos;
     }
}
