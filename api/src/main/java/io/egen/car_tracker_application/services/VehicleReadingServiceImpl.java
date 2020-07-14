package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.VehicleReadings;
import io.egen.car_tracker_application.repositories.VehicleReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("vehiclereadingservice")
public class VehicleReadingServiceImpl implements VehicleReadingService {

    private VehicleReadingRepository vehicleReadingRepository;

    @Autowired
    public VehicleReadingServiceImpl(VehicleReadingRepository vehicleReadingRepository) {
        this.vehicleReadingRepository = vehicleReadingRepository;
    }

    @Override
    public void addVehicleReading(VehicleReadings vehicleReading) {
            //for(VehicleReadings vehicleReading: vehicleReadings )
                this.vehicleReadingRepository.save(vehicleReading);
    }
}
