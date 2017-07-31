package io.egen.service;


import java.util.HashMap;
import io.egen.entity.WeatherReading;
import io.egen.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherRepository weatherRepository;

    public void insertWeatherReadings(List<WeatherReading> r) {
        for (int i = 0; i < r.size(); i++) {
            WeatherReading r1 = r.get(i);
            weatherRepository.insertWeatherReadings(r1);
        }
    }

    public List<String> getReportedCities() {
        return weatherRepository.getReportedCities();
    }

    public WeatherReading getLatestWeatherForCity(String city) {
        return weatherRepository.getLatestWeatherForCity(city);
    }

    public Integer getLatestWeatherPropForCity(String weatherProperty, String city) {
        return weatherRepository.getLatestWeatherPropForCity(weatherProperty,city);
    }

    public WeatherReading getHourlyAvgWeatherForCity(String city) {
        return null;
    }

    public List<HashMap<String,String>> getDailyAvgWeatherForCity(String city) {
        return weatherRepository.getDailyAvgWeatherForCity(city);
    }


}