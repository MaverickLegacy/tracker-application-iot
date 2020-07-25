package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.Alert;
import io.egen.car_tracker_application.domain.ReadingId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertsRepository extends JpaRepository<Alert, ReadingId> {
  public Iterable<Alert> findAlertById_VehicleId(String vehicleId);
}
