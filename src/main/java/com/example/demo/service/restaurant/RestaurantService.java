package com.example.demo.service.restaurant;

import com.example.demo.dto.RestaurantRegistrationDto;
import com.example.demo.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    void saveRestaurant(RestaurantRegistrationDto restaurantRegistrationDto);

    List<Restaurant> findAllRestaurants();

    void removeRestaurant(Long id);
    void updateRestaurant(Long id,Restaurant restaurant);

    Restaurant findById(Long id);

    RestaurantRegistrationDto produceDto(Long id,Restaurant restaurant);

//    Restaurant findRestaurantByName(String name);


}
