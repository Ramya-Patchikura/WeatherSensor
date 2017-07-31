package io.egen.api_boot.service;

import io.egen.api_boot.repository.WeatherRepository;
import io.egen.api_boot.entity.WeatherReading;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeatherServiceImpl implements WeatherService {
    private WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public void insertWeatherReadings(List<WeatherReading> r) {
        for (int i = 0; i < r.size(); i++) {
            WeatherReading r1 = r.get(i);
            repository.save(r1);
            }
        }


    @Transactional
    public List<WeatherReading> getWeatherForCity (String city){
        return repository.findByCity(city);
    }


    @Transactional
    public List<WeatherReading> displayWeatherReadings () {
        return repository.findAll();
    }



}
