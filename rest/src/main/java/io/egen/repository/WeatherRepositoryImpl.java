package io.egen.repository;



import io.egen.entity.WeatherReading;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWeatherReadings(WeatherReading reading) {
        entityManager.persist(reading);
    }


    @Transactional
    public List<String> getReportedCities() {
        TypedQuery<String> query = entityManager.createNamedQuery("WeatherReading.reportedCities", String.class);
        return query.getResultList();
    }

    @Transactional
    public WeatherReading getLatestWeatherForCity(String city) {
        Query query = entityManager.createNativeQuery
                ("SELECT * FROM weather_db.weatherreading w WHERE w.city = ?1 ORDER BY (w.timestamp) DESC LIMIT 1",
                        WeatherReading.class);
        query.setParameter(1, city);
        List<WeatherReading> resultList = query.getResultList();
        if (resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null; // Exception can be thrown
        }
    }

    @Transactional
    public Integer getLatestWeatherPropForCity(String weatherProperty, String city) {
        Query query = null;
        if (weatherProperty.contains("wind")) {
            String s=weatherProperty.substring(4);
            query = entityManager.createNativeQuery
                    ("SELECT" + " " + s + " " +
                            "FROM weather_db.wind wind WHERE wind.wid=(SELECT w.wind_wid FROM weather_db.weatherreading w WHERE w.city =?1 ORDER BY (w.timestamp) DESC LIMIT 1)");
            query.setParameter(1, city);
            Float value1 = (Float) query.getSingleResult();
            Integer  newValue = value1.intValue();
            return newValue;
        }
        else {
            query = entityManager.createNativeQuery
                    ("SELECT" + " " + weatherProperty + " " +
                            "FROM weather_db.weatherreading w WHERE w.city = ?1 ORDER BY (w.timestamp) DESC LIMIT 1");
            query.setParameter(1, city);
            Integer  value = (Integer) query.getSingleResult();
            return value;
        }

    }




    public WeatherReading getHourlyAvgWeatherForCity(String city) {
        return null;
    }


    public List<HashMap<String,String>> getDailyAvgWeatherForCity(String city)
    {
        List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
 Query query= entityManager.createNativeQuery("SELECT cast(w.timestamp AS DATE) AS timestamp, AVG(w.humidity) AS humidity, AVG(w.pressure) AS pressure, AVG(w.temperature) AS temperature"
+" "+" FROM weather_db.weatherreading w WHERE city=?1 GROUP BY CAST(w.timestamp AS DATE) ORDER BY CAST(w.timestamp AS DATE) ASC" );
        query.setParameter(1,city);
       List<Object[]> resultList= query.getResultList();

        for (Object[] result : resultList) {
            HashMap<String,String> map = new HashMap<String, String>();
           map.put("Timestamp",result[0].toString());
           map.put("Humidity",result[1].toString());
           map.put("Pressure",result[2].toString());
           map.put("Temperature",result[3].toString());
        list.add(map);

        }
        return list;
    }


}