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

}
