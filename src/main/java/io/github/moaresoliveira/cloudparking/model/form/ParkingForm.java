package io.github.moaresoliveira.cloudparking.model.form;

import io.github.moaresoliveira.cloudparking.model.Parking;
import lombok.Data;

@Data
public class ParkingForm {

    private String license;
    private String state;
    private String model;
    private String color;


}
