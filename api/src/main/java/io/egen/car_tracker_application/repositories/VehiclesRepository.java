package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehiclesRepository extends CrudRepository<Vehicle, String> {

}
