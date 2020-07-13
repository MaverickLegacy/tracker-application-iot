package io.egen.car_tracker_application.domain;

import javax.persistence.Id;

public class Alerts {

    @Id
    private String vin;
    @Id
    private String timestamp;

    private AlertType level;
}
