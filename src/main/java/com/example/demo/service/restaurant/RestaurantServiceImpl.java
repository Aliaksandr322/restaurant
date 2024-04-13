package com.example.demo.service.restaurant;

import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    private RestaurantRepository repository;


    @Override
    public void addNewRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public void removeRestaurant(Integer id) {
        repository.getReferenceById(id);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(Integer id) {
        return repository.getReferenceById(id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }
}
