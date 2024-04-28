package com.example.demo.enums;

import lombok.Data;


public enum TypeOfRestaurant {
    JapanRestaurant ("JapanRestaurant"),
    ItalianRestaurant("ItalianRestaurant"),
    MexicanRestaurant("MexicanRestaurant"),
    BelarusianRestaurant("BelarusianRestaurant"),
    RussianRestaurant("RussianRestaurant"),
    UkrainianRestaurant("UkrainianRestaurant"),
    Other("Other");
    private String restaurantType ;
    TypeOfRestaurant(String restaurantType) {
        this.restaurantType = restaurantType;
    }
    public String getRestaurantType() {
        return restaurantType;
    }
}
