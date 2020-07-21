package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.AlertType;
import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;
import io.egen.car_tracker_application.repositories.AlertsRepository;
import io.egen.car_tracker_application.repositories.VehicleReadingRepository;
import io.egen.car_tracker_application.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("vehicleServiceImpl")
public class VehicleServiceImpl implements VehicleService {

    private final VehiclesRepository vehiclesRepository;

    private final VehicleReadingRepository vehicleReadingRepository;

    private final AlertsRepository alertsRepository;


    @Autowired
    VehicleServiceImpl(VehiclesRepository vehiclesRepository,
                       VehicleReadingRepository vehicleReadingRepository,
                       AlertsRepository alertsRepository)
    {
        this.vehiclesRepository = vehiclesRepository;
        this.vehicleReadingRepository = vehicleReadingRepository;
        this.alertsRepository = alertsRepository;
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

            Optional<AlertType> alertType = calcAlert(vehicle.get(), vehicleReading);
            if(alertType.isPresent()){
                Alert alert = new Alert();
                alert.setId(vehicleReading.getReadingId());
                alert.setType(alertType.get());
                alert.setVehicle(vehicle.get());
                this.alertsRepository.save(alert);
            }
            //vehicle.get().getVehicleReadings().add(vehicleReading);
            this.vehicleReadingRepository.save(vehicleReading);
        }
    }


    public Optional<AlertType> calcAlert(Vehicle vehicle, VehicleReading vehicleReading) {

        if(vehicleReading.getEngineRpm() > vehicle.getRedlineRpm()){
            System.out.println("High alert");
            return Optional.of(AlertType.HIGH);
        }

        else if(vehicleReading.getFuelVolume() < 0.1 * vehicle.getMaxFuelVolume())
            return Optional.of(AlertType.MEDIUM);
        else if(vehicleReading.getTires().getFrontLeft() < 32 ||
                vehicleReading.getTires().getFrontLeft() > 36 ||
                vehicleReading.getTires().getFrontRight() < 32||
                vehicleReading.getTires().getFrontRight() > 36 ||
                vehicleReading.getTires().getRearLeft() < 32 ||
                vehicleReading.getTires().getRearLeft() >36 ||
                vehicleReading.getTires().getRearRight() < 32 ||
                vehicleReading.getTires().getRearRight() > 36) {
            return Optional.of(AlertType.LOW);
        }
        else if( vehicleReading.getCheckEngineLightOn() == true || vehicleReading.getEngineCoolantLow() == true){
            return Optional.of(AlertType.LOW);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Alert> getAlerts() {
      return  this.alertsRepository.findAll();
    }

    @Override
    public Iterable<Float> getReadings() {
//        return this.vehicleReadingRepository.findByMyQuery();
        return this.vehicleReadingRepository.findAllSomeMethod();
    }
}
