package com.example.demo.service.restaurant;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;


import java.util.List;

public interface UserService{

    void saveUser(UserRegistrationDto userRegistrationDto);
    User findUserByEmail(String email);
    List<UserRegistrationDto> findAllUsers();

}
