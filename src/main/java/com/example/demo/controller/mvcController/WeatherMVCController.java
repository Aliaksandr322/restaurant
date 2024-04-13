package com.example.demo.controller.mvcController;

import com.example.demo.dto.CityWeatherDTO;
import com.example.demo.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherMVCController {
//    @Autowired
//    private WeatherService weatherService;
//
//    @GetMapping()
//    public String getCityTable(Model model){
//        List<CityWeatherDTO> list = weatherService.getCitiesWeather();
//        model.addAttribute("list", list);
//        return "weather_table";
//    }


}
