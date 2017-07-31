package io.egen.api_boot.repository;

import io.egen.api_boot.entity.WeatherReading;
import org.springframework.data.repository.Repository;
import java.util.List;



public interface WeatherRepository extends Repository<WeatherReading, String >
    {
        void  save(WeatherReading reading);
        List<WeatherReading> findByCity(String city);
        List<WeatherReading> findAll();

    }


