package io.egen.car_tracker_application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Alerts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @EmbeddedId
    ReadingId id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private AlertType type;

    @ManyToOne(targetEntity = Vehicle.class, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name ="vehicleId", referencedColumnName = "vin",  insertable = false, updatable = false)
    //@JoinColumn(name ="timestamp", referencedColumnName = "timestamp",  insertable = false, updatable = false)
    @MapsId(value = "vehicleId")
    private Vehicle vehicle;
}
