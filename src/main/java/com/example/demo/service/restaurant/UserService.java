package com.example.demo.service.restaurant;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;


import java.util.List;

public interface UserService{

    User addNewUser(UserRegistrationDto user);

    User findUserByEmail(String email);
    void removeUser(Integer id);
    User updateUser(User user);
    User getUserById(Integer id);
    List<User> getAllUsers();

}
