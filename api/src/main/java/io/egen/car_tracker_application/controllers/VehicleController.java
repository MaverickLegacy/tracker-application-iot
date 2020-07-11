package io.egen.car_tracker_application.controllers;

import com.sun.istack.NotNull;
import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
@RestController
public class VehicleController {

    final private VehicleService vehicleService;

    @Autowired
    VehicleController(@Qualifier("vehicleServiceImpl") VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PutMapping("/vehicles")
    public void addVehicles(@RequestBody @NotNull Vehicle[] vehicles) {

        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
        }
        this.vehicleService.addVehicles(vehicles);
    }

    @PutMapping("/vehicles/add")
    public void addVehicle(@RequestBody @NotNull Vehicle vehicle) {
        this.vehicleService.addVehicle(vehicle);
    }
}