package io.egen.car_tracker_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingsEntityToDto {
    private LocalDateTime timestamp;

    private String vehicleId;

    private Float latitude;

    private Float longitude;

    private Float fuelVolume;

    private Boolean checkEngineLightOn;

    private Boolean engineCoolantLow;

    private Integer engineRpm;

}
