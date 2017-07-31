package io.egen.api_boot.entity;

import java.util.UUID;

        import com.fasterxml.jackson.annotation.JsonIgnore;

        import javax.persistence.*;

@Entity

public class WeatherReading {

    @Id//PK
    @Column(columnDefinition = "VARCHAR(36)")
    @JsonIgnore
    private String wrId;

    private String city;
    private String description;
    private int humidity;
    private int pressure;
    private int temperature;

    @OneToOne(cascade = {CascadeType.ALL})
    private Wind wind;
    private String timestamp;


    public WeatherReading() {
        this.wrId = UUID.randomUUID().toString();
    }

    public String getWrId() {
        return wrId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherReading{" +
                "wrid='" + wrId + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", wind=" + wind +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}



