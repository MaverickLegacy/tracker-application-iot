package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.ReadingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertsRepository extends JpaRepository<Alert, ReadingId> {
  //public Optional<Alert> getAlertsById_VehicleId(String vehicleId);
}
