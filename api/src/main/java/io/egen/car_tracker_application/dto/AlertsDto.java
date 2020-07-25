package io.egen.car_tracker_application.dto;

import io.egen.car_tracker_application.domain.AlertType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertsDto {
    private String vehicleId;
    private LocalDateTime timestamp;
    private AlertType type;
}
