package io.github.moaresoliveira.cloudparking.exception;

public class ParkingNotFoundException extends IllegalArgumentException {
    public ParkingNotFoundException(String id) {
        super("Parking not found with id: " + id);
    }
}
