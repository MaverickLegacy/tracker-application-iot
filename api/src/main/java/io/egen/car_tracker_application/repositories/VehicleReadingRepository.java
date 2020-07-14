package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.ReadingId;
import io.egen.car_tracker_application.domain.VehicleReadings;
import org.springframework.data.repository.CrudRepository;

public interface VehicleReadingRepository extends CrudRepository<VehicleReadings, ReadingId> {
}
