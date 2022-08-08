package io.github.moaresoliveira.cloudparking.service;

import io.github.moaresoliveira.cloudparking.model.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.form.ParkingForm;

import java.util.List;

public interface ParkingService {

    List<ParkingDTO> getAll();

    ParkingDTO getById(String id);

    ParkingDTO save(ParkingForm parking);

    ParkingDTO update(String id, ParkingForm parking);

    void delete(String id);

    ParkingDTO exitParking(String id);
}
