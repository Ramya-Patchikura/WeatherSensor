package io.egen.service;
import java.util.HashMap;


import io.egen.entity.WeatherReading;

import java.util.List;

public interface WeatherService
{
    void insertWeatherReadings(List<WeatherReading> readings);
    List<String> getReportedCities();
    WeatherReading getLatestWeatherForCity(String city);
    Integer  getLatestWeatherPropForCity(String weatherProperty ,String city);
    WeatherReading getHourlyAvgWeatherForCity(String city);
    List<HashMap<String,String>> getDailyAvgWeatherForCity(String city);
}
