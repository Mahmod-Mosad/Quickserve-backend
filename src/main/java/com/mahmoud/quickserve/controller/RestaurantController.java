package com.mahmoud.quickserve.controller;

import com.mahmoud.quickserve.DTO.RestaurantResponseDTO;
import com.mahmoud.quickserve.model.Restaurant;
import com.mahmoud.quickserve.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<RestaurantResponseDTO>> getNearbyRestaurants(
            @RequestParam Double lat,
            @RequestParam Double lng) {

        List<RestaurantResponseDTO>  restaurantDTOList = restaurantService.getNearbyRestaurants(lat, lng);
        return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);

    }

}