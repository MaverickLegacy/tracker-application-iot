package io.egen.car_tracker_application.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReadingId implements Serializable {

    @Column(name = "timestamp")
    String timestamp;

    String vehicleId;

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, vehicleId);
    }
    @Override
    public boolean equals(Object obj) {
        ReadingId other = (ReadingId)obj;
        if(timestamp.equals(other.timestamp) && vehicleId.equals(other.vehicleId))
            return true;
        return false;
    }
}
