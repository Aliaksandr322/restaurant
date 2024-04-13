package com.example.demo.controller;

import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.model.User;
import com.example.demo.service.restaurant.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestMainController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ModelAndView main(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_registration.html");
        User user = new User();
        model.addAttribute("user", user);
        return modelAndView;
    }

    @PostMapping("/registration/create")
    public ModelAndView createNewUser(@Valid @ModelAttribute("user") UserRegistrationDto newUser,
                                      BindingResult result,
                                      Model model){
        ModelAndView modelAndView = new ModelAndView();
        User existingUser = userService.findUserByEmail(newUser.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", newUser);
            modelAndView.setViewName("user_registration.html");
            return modelAndView;
        }
        modelAndView.setViewName("index.html");
        userService.addNewUser(newUser);
        return modelAndView;
    }
    @GetMapping("/login")
    public ModelAndView getLoginForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_login.html");
        User user = new User();
        model.addAttribute("user", user);
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@Valid @ModelAttribute("user") UserRegistrationDto newUser,
                                      BindingResult result,
                                      Model model){
        ModelAndView modelAndView = new ModelAndView();
        User existingUser = userService.findUserByEmail(newUser.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", newUser);
            modelAndView.setViewName("user_login.html");
            return modelAndView;
        }
        if(!newUser.getPassword().equals(existingUser.getPassword())){
            result.reject("Wrong email or password");
        }
        modelAndView.setViewName("index.html");
        userService.addNewUser(newUser);
        return modelAndView;
    }
}
