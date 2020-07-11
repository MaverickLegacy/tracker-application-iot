package io.egen.car_tracker_application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Vehicle {
    @Id
    private String vin;

    private String make;

    private String model;

    private Integer year;

    private Integer redlinerpm;

    private Integer maxfuelvolume;

    private String lastServiceDate;

    public Vehicle() {
    }

    public Vehicle(@JsonProperty("vin") String vin, @JsonProperty("make") String make, @JsonProperty("model") String model, @JsonProperty("year") Integer year,
                   @JsonProperty("redlineRpm") Integer redlinerpm, @JsonProperty("maxFuelVolume") Integer maxfuelvolume, @JsonProperty("lastServiceDate") String lastServiceDate)
    {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.year = year;
        this.redlinerpm = redlinerpm;
        this.maxfuelvolume = maxfuelvolume;
        this.lastServiceDate = lastServiceDate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlinerpm() {
        return redlinerpm;
    }

    public void setRedlinerpm(int redlinerpm) {
        this.redlinerpm = redlinerpm;
    }

    public int getMaxfuelvolume() {
        return maxfuelvolume;
    }

    public void setMaxfuelvolume(int maxfuelvolume) {
        this.maxfuelvolume = maxfuelvolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
}
