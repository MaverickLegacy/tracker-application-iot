package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.AlertType;
import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;
import io.egen.car_tracker_application.dto.AlertsDto;
import io.egen.car_tracker_application.dto.GeolocationDto;
import io.egen.car_tracker_application.dto.ReadingsEntityToDto;

import java.util.Optional;

public interface VehicleService {

    public void addVehicles(Vehicle[] vehicles);
    public void addVehicle(Vehicle vehicle);
    public Iterable<Vehicle> getVehicles();
    public void addVehicleReading(VehicleReading vehicleReading);
    public Optional<AlertType> calcAlert(Vehicle vehicle, VehicleReading vehicleReading);
    public Iterable<Alert> getAlerts();
    public Iterable<ReadingsEntityToDto> getReadings();
    public Iterable<AlertsDto> getAlertsByVehicleId(String vin);
    public Iterable<GeolocationDto> getLocationByVehicleIdAndTimestamp(String vehicleId);
}

