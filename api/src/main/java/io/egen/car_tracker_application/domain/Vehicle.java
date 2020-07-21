package io.egen.car_tracker_application.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Vehicle {

    @Id
    @Column(name = "vin")
    private String vin;

    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;

    @Column(name = "redlineRpm")
    private Integer redlineRpm;
    @Column(name = "maxFuelVolume")
    private Integer maxFuelVolume;
    @Column(name = "lastServiceDate")
    private String lastServiceDate;

    /*
    @OneToMany(targetEntity = VehicleReading.class, cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Set<VehicleReading> vehicleReadings = new HashSet<>();

    @OneToMany(targetEntity = Alert.class, cascade = CascadeType.ALL, mappedBy = "vehicle")
    private Set<Alert> allAlerts = new HashSet<>();

    public Set<Alert> getAllAlerts(){
        return this.allAlerts;
    }
    */
}
