package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.ReadingId;
import io.egen.car_tracker_application.domain.VehicleReading;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, ReadingId> {
//    @Query("SELECT v.latitude FROM VehicleReading")
//    List<VehicleReading> findByMyQuery();

    @Query("SELECT v.latitude FROM VehicleReading v")
    ArrayList<Float> findAllSomeMethod();
}
