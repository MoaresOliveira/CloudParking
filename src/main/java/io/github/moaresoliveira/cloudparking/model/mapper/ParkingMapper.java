package io.github.moaresoliveira.cloudparking.model.mapper;

import io.github.moaresoliveira.cloudparking.model.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.Parking;
import io.github.moaresoliveira.cloudparking.model.form.ParkingForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toDTO(List<Parking> parkings) {
        return parkings.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Parking toEntity(ParkingDTO parkingDTO) {
        return MODEL_MAPPER.map(parkingDTO, Parking.class);
    }

    public Parking toEntity(ParkingForm parkingForm) {
        return MODEL_MAPPER.map(parkingForm, Parking.class);
    }

}
