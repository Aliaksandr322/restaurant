package com.example.demo.controller.mvcController;


import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.restaurant.MailSenderService;
import com.example.demo.service.restaurant.RestaurantService;
import com.example.demo.service.restaurant.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthController {
    private final MailSenderService mailService;
    private final UserService userService;
    private final RestaurantService restaurantService;



    public AuthController(UserService userService, RestaurantService restaurantService, MailSenderService mailService) {
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.mailService = mailService;
    }


    // handler method to handle home page request
    @GetMapping("/index")
    public ModelAndView home(ModelAndView modelAndView){
        List<Restaurant> restaurantList = restaurantService.findAllRestaurants();
        modelAndView.addObject("restaurant_list", restaurantList);
        modelAndView.setViewName("index");
        return modelAndView;
    }
    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserRegistrationDto user = new UserRegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }
    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.saveUser(userDto);
        mailService.sendNewMail(userDto.getEmail(),"Confirm your email",  "URL");
        return "redirect:/register?success";
    }
    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model) {
        List<UserRegistrationDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
