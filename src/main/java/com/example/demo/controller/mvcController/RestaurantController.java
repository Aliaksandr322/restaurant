package com.example.demo.controller.mvcController;

import com.example.demo.dto.RestaurantRegistrationDto;

import com.example.demo.model.Reservation;
import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.service.restaurant.ReservationService;
import com.example.demo.service.restaurant.RestaurantService;
import com.example.demo.service.restaurant.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    private final ReservationService reservationService;

    private final UserService userService;

    public RestaurantController(RestaurantService restaurantService, ReservationService reservationService, UserService userService) {
        this.restaurantService = restaurantService;
        this.reservationService = reservationService;
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        RestaurantRegistrationDto restaurantRegistrationDto = new RestaurantRegistrationDto();
        model.addAttribute("restaurant", restaurantRegistrationDto);
        return "register_new_restaurant";
    }
    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") RestaurantRegistrationDto restaurantRegistrationDto,
                               BindingResult result,
                               Model model){
//        Restaurant existingRestaurant = restaurantService.findRestaurantByName(restaurantRegistrationDto.getRestaurantName());
//        if(existingRestaurant != null && existingRestaurant.getRestaurantName() != null && !existingRestaurant.getRestaurantName().isEmpty()){
//            result.rejectValue("Restaurant Name", null,
//                    "There is already an account registered with the same name");
//        }
//        if(result.hasErrors()){
//            model.addAttribute("restaurant", restaurantRegistrationDto);
//            return "/register";
//        }
        restaurantService.saveRestaurant(restaurantRegistrationDto);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        restaurantService.removeRestaurant(id);
        return "redirect:/index";
    }

    @GetMapping("/update/{id}")
    public String showRegistrationForm(@PathVariable Long id, Model model){
        RestaurantRegistrationDto restaurantRegistrationDto = restaurantService.produceDto(id,restaurantService.findById(id));
        model.addAttribute("restaurant", restaurantRegistrationDto);
        return "update_restaurant_form";
    }

    @PostMapping("/update/save")
    public String update(@Valid @ModelAttribute("restaurant") Restaurant restaurant){
        restaurantService.updateRestaurant(restaurant.getId() ,restaurant);
        return "redirect:/index";
    }

    @GetMapping("/reservation/{id}")
    public String makeReservation(Model model, @PathVariable Long id){
        // create model object to store form data
        Reservation reservation = new Reservation();
        Restaurant restaurant = restaurantService.findById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());
        reservation.setUser(user);
        reservation.setRestaurant(restaurant);
        model.addAttribute("restaurantId", id);
        model.addAttribute("reservation", reservation);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("user", user);
        return "make_reservation";
    }

    @PostMapping("/reservation/save")
    public String reservation(@Valid @ModelAttribute("reservation") Reservation reservation){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(authentication.getName());
        reservationService.saveReservation(user.getId(), reservation.getRestaurant().getId(), reservation);
        return "redirect:/index";
    }
}
