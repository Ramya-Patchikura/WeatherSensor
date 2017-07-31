package io.egen.repository;

import io.egen.entity.WeatherReading;

import java.util.HashMap;
import java.util.List;

public interface WeatherRepository
{
    void insertWeatherReadings(WeatherReading reading);
        List<String> getReportedCities();
    WeatherReading getLatestWeatherForCity(String city);
     Integer getLatestWeatherPropForCity(String weatherProperty ,String city);
    WeatherReading getHourlyAvgWeatherForCity(String city);
    List<HashMap<String,String>> getDailyAvgWeatherForCity(String city);

}
