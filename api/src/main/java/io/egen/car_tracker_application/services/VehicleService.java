package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;

public interface VehicleService {

    public void addVehicles(Vehicle[] vehicles);
    public void addVehicle(Vehicle vehicle);
    public Iterable<Vehicle> getVehicles();
    public void addVehicleReading(VehicleReading vehicleReading);
}
