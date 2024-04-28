package com.example.demo.dto;

import com.example.demo.enums.TypeOfRestaurant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRegistrationDto {

    private String restaurantName;
    private String address;
    private String workTime;
    private TypeOfRestaurant restaurantType;
    private String phoneNumber;

}
