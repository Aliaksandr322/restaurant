package com.example.demo.controller;

import com.example.demo.dto.CityWeatherDTO;
import com.example.demo.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/restweather")
public class WeatherController {
//    @Autowired
//    private WeatherService weatherService;
//
//    @GetMapping("/list")
//    public ModelAndView getRegForm(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("weather_table.html");
//        List<CityWeatherDTO> list = weatherService.getCitiesWeather();
//        model.addAttribute("list", list);
//        return modelAndView;
//    }
}
