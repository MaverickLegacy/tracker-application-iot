package io.egen.car_tracker_application.controllers;

import com.sun.istack.NotNull;
import io.egen.car_tracker_application.domain.VehicleReadings;
import io.egen.car_tracker_application.services.VehicleReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleReadingController {
    private VehicleReadingService vehicleReadingService;

    @Autowired
    public VehicleReadingController(@Qualifier("vehiclereadingservice") VehicleReadingService vehicleReadingService) {
        this.vehicleReadingService = vehicleReadingService;
    }

    @PostMapping("/readings")
    public void addReadings(@RequestBody @NotNull VehicleReadings vehicleReading)
    {
        this.vehicleReadingService.addVehicleReading(vehicleReading);
    }

}
