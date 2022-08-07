package io.github.moaresoliveira.cloudparking.controller;

import io.github.moaresoliveira.cloudparking.exception.ParkingNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ParkingNotFoundException.class)
    public ResponseEntity<String> handleParkingNotFoundException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
