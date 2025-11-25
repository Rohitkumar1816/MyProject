package com.Rps.Weather_App.Controller;


import com.Rps.Weather_App.Dto.Forecast;
import com.Rps.Weather_App.Dto.Root;
import com.Rps.Weather_App.Dto.WeatherForecast;
import com.Rps.Weather_App.Dto.WeatherReasponse;
import com.Rps.Weather_App.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Weather")
public class WeatherController {

    @Autowired
    private WeatherService  WeatherService;
    @GetMapping("/{city}")
    public String get(@PathVariable String city){

        return WeatherService.Test();
    }
    @GetMapping("/my/{city}")
    public WeatherReasponse getWeather(@PathVariable String city){

        return WeatherService.Getdata(city);
    }
    @GetMapping("/forecast")
    public WeatherForecast getForecast(@RequestParam String city,
                                       @RequestParam int days) {

        return WeatherService.weatherForecast(city, days);   // ✔ Correct call
    }




}
