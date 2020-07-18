package io.egen.car_tracker_application.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Tires {
    @Column(name = "frontleft")
    private Integer frontLeft;
    @Column(name = "frontright")
    private Integer frontRight;
    @Column(name = "rearleft")
    private Integer rearLeft;
    @Column(name = "rearright")
    private Integer rearRight;

    public Tires() {
    }

    public Tires(@JsonProperty("frontLeft") Integer frontLeft,
                 @JsonProperty("frontRight") Integer frontright,
                 @JsonProperty("rearLeft")Integer rearleft,
                 @JsonProperty("rearRight")Integer rearRight) {
        //this.readingId = readingId;
        this.frontLeft = frontLeft;
        this.frontRight = frontright;
        this.rearLeft = rearleft;
        this.rearRight= rearRight;
    }

    public Integer getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Integer frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Integer getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Integer frontRight) {
        this.frontRight = frontRight;
    }

    public Integer getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(Integer rearLeft) {
        this.rearLeft = rearLeft;
    }

    public Integer getRearRight() {
        return rearRight;
    }

    public void setRearRight(Integer rearRight) {
        this.rearRight = rearRight;
    }

}
