package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityWeatherDTO {
    private String cityName;
    private String maxTemp;
    private String minTemp;
    private String precip;
    private Date updatedTs;
    private Date createdTs;
}
