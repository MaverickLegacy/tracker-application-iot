package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vehicleServiceImpl")
public class VehicleServiceImpl implements VehicleService {

    private final VehiclesRepository vehiclesRepository;

    @Autowired
    VehicleServiceImpl(VehiclesRepository vehiclesRepository)
    {
        this.vehiclesRepository = vehiclesRepository;
    }
    @Override
    public void addVehicles(Vehicle[] vehicles) {
        for(Vehicle vehicle: vehicles)
            this.vehiclesRepository.save(vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle)
    {
        this.vehiclesRepository.save(vehicle);
    }
}
