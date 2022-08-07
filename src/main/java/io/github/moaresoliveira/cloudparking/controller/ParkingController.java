package io.github.moaresoliveira.cloudparking.controller;

import io.github.moaresoliveira.cloudparking.controller.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<ParkingDTO> getAll() {

        return parkingService.getAll();
    }

}
