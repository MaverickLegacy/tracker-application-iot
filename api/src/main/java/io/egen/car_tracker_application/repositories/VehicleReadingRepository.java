package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.ReadingId;
import io.egen.car_tracker_application.domain.VehicleReading;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, ReadingId> {
 public Iterable<VehicleReading> getVehicleReadingsByReadingId_VehicleIdAndReadingId_TimestampBetween(String vehicleId, LocalDateTime t1, LocalDateTime t2);
}
