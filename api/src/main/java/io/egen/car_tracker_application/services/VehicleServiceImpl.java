package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;
import io.egen.car_tracker_application.repositories.VehicleReadingRepository;
import io.egen.car_tracker_application.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("vehicleServiceImpl")
public class VehicleServiceImpl implements VehicleService {

    private final VehiclesRepository vehiclesRepository;

    private final VehicleReadingRepository vehicleReadingRepository;

    @Autowired
    VehicleServiceImpl(VehiclesRepository vehiclesRepository, VehicleReadingRepository vehicleReadingRepository)
    {
        this.vehiclesRepository = vehiclesRepository;
        this.vehicleReadingRepository = vehicleReadingRepository;
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

    public Iterable<Vehicle> getVehicles(){
        return this.vehiclesRepository.findAll();
    }

    @Override
    public void addVehicleReading(VehicleReading vehicleReading) {
        Optional<Vehicle> vehicle = vehiclesRepository.findById(vehicleReading.getReadingId().getVehicleId());
        if(vehicle.isPresent()){
            vehicleReading.setVehicle(vehicle.get());
            this.vehicleReadingRepository.save(vehicleReading);
        }
    }
}
