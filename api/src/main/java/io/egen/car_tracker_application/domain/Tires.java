package io.egen.car_tracker_application.domain;

import javax.persistence.Column;
import javax.persistence.OneToOne;

public class Tires {

    @Column(name = "frontleft")
    private Integer frontLeft;
    @Column(name = "frontright")
    private Integer frontRight;
    @Column(name = "rearleft")
    private Integer rearLeft;
    @Column(name = "rearleft")
    private Integer rearRight;

    @OneToOne
    private Tires tires;

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
