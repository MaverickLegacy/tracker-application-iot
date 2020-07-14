package io.egen.car_tracker_application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Readings")
public class VehicleReadings {

        @EmbeddedId
        private ReadingId readingId;

        @ManyToOne(optional = false)
        @JoinColumn(nullable = false, referencedColumnName="vin" )
        Vehicle vehicle;
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

        @OneToOne(cascade = CascadeType.ALL)
        private Tires tires;

        public VehicleReadings() {
        }

        public String getVin() {
            return vehicle.getVin();
        }

        public void setVin(String vin) {
            this.vehicle.setVin(vin);
        }

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        public String getTimestamp() {
            return this.readingId.timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.readingId.timestamp = timestamp;
        }

        public Float getFuelVolume() {
            return fuelVolume;
        }

        public void setFuelVolume(Float fuelVolume) {
            this.fuelVolume = fuelVolume;
        }

        public Boolean getCheckEngineLightOn() {
            return checkEngineLightOn;
        }

        public void setCheckEngineLightOn(Boolean checkEngineLightOn) {
            this.checkEngineLightOn = checkEngineLightOn;
        }

        public Boolean getEngineCoolantLow() {
            return engineCoolantLow;
        }

        public void setEngineCoolantLow(Boolean engineCoolantLow) {
            this.engineCoolantLow = engineCoolantLow;
        }

        public Integer getEngineRpm() {
            return engineRpm;
        }

        public void setEngineRpm(Integer engineRpm) {
            this.engineRpm = engineRpm;
        }

        public VehicleReadings(ReadingId readingId,
                               @JsonProperty("latitude") Float latitude,
                               @JsonProperty("longitude") Float longitude,
                               @JsonProperty("fuelVolume") Float fuelVolume,
                               @JsonProperty("checkEngineLightOn") Boolean checkEngineLightOn,
                               @JsonProperty("engineCoolantLow") Boolean engineCoolantLow,
                               @JsonProperty("engineRpm") Integer enginerpm){
            this.readingId = readingId;
            this.latitude = latitude;
            this.latitude = latitude;
            this.longitude = longitude;
            this.checkEngineLightOn = checkEngineLightOn;
            this.engineCoolantLow = engineCoolantLow;
            this.engineRpm = enginerpm;
            this.fuelVolume = fuelVolume;
        }
}


