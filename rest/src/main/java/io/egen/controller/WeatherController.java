package io.egen.controller;


import java.util.HashMap;
import io.egen.entity.WeatherReading;
import io.egen.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @RequestMapping(method = RequestMethod.POST, value = "WeatherReadings",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void insertWeatherReadings(@RequestBody List<WeatherReading> readings) {
        System.out.println(" Weather Controller ");
        weatherService.insertWeatherReadings(readings);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getReportedCities",
                       produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<String> getReportedCities()
    {
       return weatherService.getReportedCities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getLatestWeatherForCity/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WeatherReading getLatestWeatherForCity(@PathVariable(value="city") String city)
    {
         return weatherService.getLatestWeatherForCity(city);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getLatestWeatherPropForCity/{weatherProperty}/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  Integer getLatestWeatherPropForCity( @PathVariable(value="weatherProperty") String weatherProperty, @PathVariable(value="city") String city)
    {
        return weatherService.getLatestWeatherPropForCity(weatherProperty,city);

    }




    @RequestMapping(method = RequestMethod.GET, value = "getHourlyAvgWeatherForCity/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WeatherReading getHourlyAvgWeatherForCity(@PathVariable(value="city") String city)
    {
        return weatherService.getHourlyAvgWeatherForCity(city);

    }

    @RequestMapping(method = RequestMethod.GET, value = "getDailyAvgWeatherForCity/{city}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<HashMap<String,String>> getDailyAvgWeatherForCity(@PathVariable(value="city") String city)
    {
        return weatherService.getDailyAvgWeatherForCity(city);

    }







}
