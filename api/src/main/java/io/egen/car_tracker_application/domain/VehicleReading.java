package io.egen.car_tracker_application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Readings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VehicleReading {
        @EmbeddedId
        private ReadingId readingId;

        @ManyToOne( targetEntity = Vehicle.class, fetch = FetchType.EAGER,optional = false)
        @JoinColumn(name ="vehicleId", referencedColumnName = "vin",  insertable = false, updatable = false)
        @MapsId(value = "vehicleId")
        private Vehicle vehicle;

        @Column(name= "latitude")
        private Float latitude;

        @Column(name = "longitude")
        private Float longitude;

        @Column(name = "fuelvolume")
        private Float fuelVolume;

        @Column(name = "checkenginelighton")
        private Boolean checkEngineLightOn;

        @Column(name = "enginecoolantlow")
        private Boolean engineCoolantLow;

        @Column(name = "enginerpm")
        private Integer engineRpm;

        @Embedded
        private Tires tires;

        VehicleReading(@JsonProperty("timestamp") String timestamp,
                       @JsonProperty("vin") String vehicleId,
                       @JsonProperty("latitude") Float latitude,
                       @JsonProperty("longitude") Float longitude,
                       @JsonProperty("fuelVolume") Float fuelVolume,
                       @JsonProperty("checkEngineLightOn") Boolean checkEngineLightOn,
                       @JsonProperty("engineCoolantLow") Boolean engineCoolantLow,
                       @JsonProperty("engineRpm") Integer engineRpm,
                       @JsonProperty("tires") Tires tires){

                this.readingId = new ReadingId(vehicleId, timestamp);
                this.latitude = latitude;
                this.longitude = longitude;
                this.fuelVolume = fuelVolume;
                this.checkEngineLightOn = checkEngineLightOn;
                this.engineCoolantLow = engineCoolantLow;
                this.engineRpm = engineRpm;
                this.tires = tires;
        }


/*

        public void setVehicle(Vehicle vehicle) {
                this.vehicle = vehicle;
        }

*/

        //    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehicleReading")
//        private Tires tires;


        @Override
        public String toString() {
                return "{" + this.readingId.timestamp + "\n"
                        + this.readingId.vehicleId +"\n"+
                        this.longitude + "\n"
                        +this.latitude + "}";
        }
}


