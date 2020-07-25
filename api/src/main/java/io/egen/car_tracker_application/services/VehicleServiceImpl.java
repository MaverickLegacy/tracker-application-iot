package io.egen.car_tracker_application.services;

import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.AlertType;
import io.egen.car_tracker_application.domain.Vehicle;
import io.egen.car_tracker_application.domain.VehicleReading;
import io.egen.car_tracker_application.dto.AlertsDto;
import io.egen.car_tracker_application.dto.GeolocationDto;
import io.egen.car_tracker_application.dto.ReadingsEntityToDto;
import io.egen.car_tracker_application.repositories.AlertsRepository;
import io.egen.car_tracker_application.repositories.VehicleReadingRepository;
import io.egen.car_tracker_application.repositories.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public Iterable<ReadingsEntityToDto> getReadings() {

        Iterable<VehicleReading> allVehicleReadings = this.vehicleReadingRepository.findAll();
        ArrayList<ReadingsEntityToDto> dtos = new ArrayList<ReadingsEntityToDto>();
        for(VehicleReading v: allVehicleReadings){
            ReadingsEntityToDto dto = new ReadingsEntityToDto();
            dto.setTimestamp(v.getReadingId().getTimestamp());
            dto.setVehicleId(v.getReadingId().getVehicleId());
            dto.setLongitude(v.getLongitude());
            dto.setLatitude(v.getLatitude());
            dto.setEngineRpm(v.getEngineRpm());
            dto.setFuelVolume(v.getFuelVolume());
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public Iterable<AlertsDto> getAlertsByVehicleId(String vin) {
        ArrayList<AlertsDto> dtos = new ArrayList<>();
        for(Alert a: this.alertsRepository.findAlertById_VehicleId(vin))
        {
            AlertsDto al = new AlertsDto();
            al.setVehicleId(a.getId().getVehicleId());
            al.setTimestamp(a.getId().getTimestamp());
            al.setType(a.getType());
            dtos.add(al);
        }
        return dtos;
    }

    @Override
    public Iterable<GeolocationDto> getLocationByVehicleIdAndTimestamp(String vehicleId) {
        ArrayList<GeolocationDto> dtos = new ArrayList<>();
        LocalDateTime l1 = LocalDateTime.parse("2017-05-25T17:45:25.268");
        LocalDateTime l2= l1.minusMinutes(30);
        Iterable<VehicleReading> readings = this.vehicleReadingRepository.getVehicleReadingsByReadingId_VehicleIdAndReadingId_TimestampBetween(vehicleId, l1, l2);
        for(VehicleReading r: readings){
            GeolocationDto loc = new GeolocationDto();
            loc.setLatitude(r.getLatitude());
            loc.setLongitude(r.getLongitude());
            dtos.add(loc);
        }
        return dtos;
    }
}
