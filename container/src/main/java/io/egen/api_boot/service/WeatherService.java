package io.egen.api_boot.service;
import io.egen.api_boot.entity.WeatherReading;

import java.util.HashMap;
import java.util.List;



    public interface WeatherService
    {
        void insertWeatherReadings(List<WeatherReading> readings);
        List<WeatherReading> getWeatherForCity(String city);
        List<WeatherReading> displayWeatherReadings();
    }

