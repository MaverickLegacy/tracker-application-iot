package io.egen.car_tracker_application.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ReadingId implements Serializable {

    @Column(name = "vehicleId")
    String vehicleId;

    @Column(name = "timestamp")
    String timestamp;

    ReadingId( @JsonProperty("vin") String vehicleId, @JsonProperty("timestamp") String timestamp){
        this.vehicleId = vehicleId;
        this.timestamp = timestamp;
    }
}
