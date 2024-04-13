package com.example.demo.service.restaurant;

import com.example.demo.model.Restaurant;
import com.example.demo.model.User;

import java.util.List;

public interface RestaurantService {
    void addNewRestaurant(Restaurant restaurant);
    void removeRestaurant(Integer id);
    Restaurant updateRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Integer id);
    List<Restaurant> getAllRestaurants();
}
