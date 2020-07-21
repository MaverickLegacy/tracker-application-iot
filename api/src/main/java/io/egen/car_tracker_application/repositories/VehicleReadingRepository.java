package io.egen.car_tracker_application.repositories;

import io.egen.car_tracker_application.domain.ReadingId;
import io.egen.car_tracker_application.domain.VehicleReading;
import org.springframework.data.repository.CrudRepository;

public interface VehicleReadingRepository extends CrudRepository<VehicleReading, ReadingId> {
//    @Query("SELECT v.latitude FROM VehicleReading")
//    List<VehicleReading> findByMyQuery();
/*
    @Query("SELECT v.latitude FROM VehicleReading v")
    ArrayList<Float> findAllSomeMethod();*/
}
