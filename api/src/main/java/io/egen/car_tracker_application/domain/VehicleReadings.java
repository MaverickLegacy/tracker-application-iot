package io.egen.car_tracker_application.domain;

import javax.persistence.*;

@Entity
@Table(name = "Readings")
public class VehicleReadings {

        @EmbeddedId
        private ReadingId readingId;

        @ManyToOne
        @JoinColumn(name="vin", nullable = false)
        Vehicle vehicle;
        @Column(name= "latitude")
        private Float latitude;
        @Column(name = "longitude")
        private Float longitude;

        @Column(name = "fuelvolume")
        private Float fuelVolume;
        @Column(name = "checkEnginelighton")
        private Boolean checkEngineLightOn;
        @Column(name = "enginecoolantlow")
        private Boolean engineCoolantLow;
        @Column(name = "enginerpm")
        private Integer engineRpm;

        @OneToOne(cascade = CascadeType.ALL, mappedBy = "tires")
        private Tires tires;

        public VehicleReadings() {
        }

        public String getVin() {
            return vin;
        }

        public void setVin(String vin) {
            this.vin = vin;
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
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
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


}


