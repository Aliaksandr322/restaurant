package com.example.demo.controller.mvcController;


import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.service.restaurant.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class AuthRestController {

    private final UserService userService;

    public AuthRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/rest/login")
    public ResponseEntity<String> login(@RequestBody UserRegistrationDto userRegistrationDto){

        userService.findUserByEmail(userRegistrationDto.getEmail());




        return new ResponseEntity<>(HttpStatus.OK);
    }



}
