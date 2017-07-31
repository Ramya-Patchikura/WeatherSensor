package io.egen.api_boot.controller;

import java.util.List;
import io.egen.api_boot.entity.WeatherReading;
import io.egen.api_boot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
    public class WeatherController {
        @Autowired
        WeatherService weatherService;

        @RequestMapping(method = RequestMethod.POST, value = "insertWeatherReadings",
                consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public void insertWeatherReadings(@RequestBody List<WeatherReading> readings) {

            weatherService.insertWeatherReadings(readings);
        }



        @RequestMapping(method = RequestMethod.GET, value = "getWeatherForCity/{city}",
                produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public  List<WeatherReading> getWeatherForCity(@PathVariable(value="city") String city)
        {
            return weatherService.getWeatherForCity(city);

        }


    @RequestMapping(method = RequestMethod.GET, value = "WeatherReadings",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<WeatherReading> displayWeatherReadings()
    {
        return weatherService.displayWeatherReadings();

    }

    }
