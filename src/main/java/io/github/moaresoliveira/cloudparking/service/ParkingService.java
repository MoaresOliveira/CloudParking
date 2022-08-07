package io.github.moaresoliveira.cloudparking.service;

import io.github.moaresoliveira.cloudparking.controller.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.Parking;

import java.util.List;

public interface ParkingService {

    List<ParkingDTO> getAll();

    ParkingDTO getById(String id);

    ParkingDTO save(Parking parking);

    ParkingDTO update(Parking parking);

    void delete(String id);

}
