package io.egen.car_tracker_application.controllers;

import com.sun.istack.NotNull;
import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;
import io.egen.car_tracker_application.dto.AlertsDto;
import io.egen.car_tracker_application.dto.GeolocationDto;
import io.egen.car_tracker_application.dto.ReadingsEntityToDto;
import io.egen.car_tracker_application.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
        /*
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle);
        }*/
        this.vehicleService.addVehicles(vehicles);
    }

    @PutMapping("/vehicles/add")
    public void addVehicle(@RequestBody @NotNull Vehicle vehicle) {
        this.vehicleService.addVehicle(vehicle);
    }


    @GetMapping("/getVehicles")
    public Iterable<Vehicle> getAllVehicles(){
       return this.vehicleService.getVehicles();
    }

    @PostMapping("/readings")
    public void addReading(@RequestBody @NotNull VehicleReading vehicleReading)
    {
        this.vehicleService.addVehicleReading(vehicleReading);
    }


    @GetMapping("/alerts/{id}")
    public Iterable<AlertsDto> getAllHistoricalAlerts(@PathVariable("id") String vin){
        return this.vehicleService.getAlertsByVehicleId(vin);
    }

    @GetMapping("/allalerts/")
    public Iterable<Alert> getAlerts(){
        return this.vehicleService.getAlerts();
    }

    @GetMapping("/givereadings")
    public Iterable<ReadingsEntityToDto> getReadings(){
        return vehicleService.getReadings();
    }

    @GetMapping("/getGeolocation/{id}")
    public Iterable<GeolocationDto> getLocations(@PathVariable("id") String vehicleId){
        return this.vehicleService.getLocationByVehicleIdAndTimestamp(vehicleId);
    }
}