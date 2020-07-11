package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Vehicle;

public interface VehicleService {

    public void addVehicles(Vehicle[] vehicles);
    public void addVehicle(Vehicle vehicle);
}
