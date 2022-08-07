package io.github.moaresoliveira.cloudparking.controller.mapper;

import io.github.moaresoliveira.cloudparking.controller.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.Parking;
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

}
