package com.example.demo.service.restaurant;

import com.example.demo.dto.RestaurantRegistrationDto;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository repository;

    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveRestaurant(RestaurantRegistrationDto restaurantRegistrationDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantRegistrationDto.getRestaurantName());
        restaurant.setAddress(restaurantRegistrationDto.getAddress());
        restaurant.setPhoneNumber(restaurantRegistrationDto.getPhoneNumber());
        restaurant.setRating(5.0);
        restaurant.setWorkTime(restaurantRegistrationDto.getWorkTime());
        restaurant.setRestaurantType(restaurantRegistrationDto.getRestaurantType());
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return repository.findAll();
    }

    @Override
    public void removeRestaurant(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateRestaurant(Long id ,Restaurant restaurant) {
        restaurant = findById(id);
        repository.save(restaurant);
    }

    @Override
    public Restaurant findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public RestaurantRegistrationDto produceDto(Long id,Restaurant restaurant) {
        restaurant = findById(id);
        RestaurantRegistrationDto registrationDto = convertToDto(restaurant);
        return registrationDto;
    }

    private RestaurantRegistrationDto convertToDto(Restaurant restaurant){
        RestaurantRegistrationDto restaurantRegistrationDto = new RestaurantRegistrationDto();
        restaurantRegistrationDto.setRestaurantName(restaurant.getRestaurantName());
        restaurantRegistrationDto.setAddress(restaurant.getAddress());
        restaurantRegistrationDto.setWorkTime(restaurant.getWorkTime());
        restaurantRegistrationDto.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantRegistrationDto.setRestaurantType(restaurant.getRestaurantType());
        return restaurantRegistrationDto;
    }
    private Restaurant convertToModel(RestaurantRegistrationDto restaurantRegistrationDto){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(restaurantRegistrationDto.getRestaurantName());
        restaurant.setAddress(restaurantRegistrationDto.getAddress());
        restaurant.setWorkTime(restaurantRegistrationDto.getWorkTime());
        restaurant.setPhoneNumber(restaurantRegistrationDto.getPhoneNumber());
        restaurant.setRestaurantType(restaurantRegistrationDto.getRestaurantType());
        return restaurant;
    }

//    @Override
//    public Restaurant findRestaurantByName(String name) {
//        return repository.findRestaurantByRestaurantName();
//    }
}
