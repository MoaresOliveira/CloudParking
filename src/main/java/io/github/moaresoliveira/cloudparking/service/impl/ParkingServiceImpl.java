package io.github.moaresoliveira.cloudparking.service.impl;

import io.github.moaresoliveira.cloudparking.controller.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.controller.mapper.ParkingMapper;
import io.github.moaresoliveira.cloudparking.exception.ParkingNotFoundException;
import io.github.moaresoliveira.cloudparking.model.Parking;
import io.github.moaresoliveira.cloudparking.service.ParkingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();
    private final ParkingMapper parkingMapper;

    public ParkingServiceImpl(ParkingMapper parkingMapper) {
        this.parkingMapper = parkingMapper;
    }

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = Parking.builder()
                .id(id)
                .license("ABC-123")
                .state("SP")
                .model("Fusca")
                .color("Vermelho")
                .entryDate(LocalDateTime.now())
                .exitDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS))
                .bill(10.0)
                .build();
        Parking parking1 = Parking.builder()
                .id(id1)
                .license("ABC-123")
                .state("SP")
                .model("Fusca")
                .color("Vermelho")
                .entryDate(LocalDateTime.now())
                .exitDate(LocalDateTime.now().plus(1, ChronoUnit.DAYS))
                .bill(10.0)
                .build();
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking);
    }

    @Override
    public List<ParkingDTO> getAll() {
        List<Parking> parking = parkingMap.values().stream().collect(Collectors.toList());
        return parkingMapper.toDTO(parking);
    }

    @Override
    public ParkingDTO getById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null) {
            throw new ParkingNotFoundException(id);
        }
        return parkingMapper.toDTO(parking);
    }

    @Override
    public ParkingDTO save(Parking parking) {
        return null;
    }

    @Override
    public ParkingDTO update(Parking parking) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    private static String getUUID() {
        // TODO
        return UUID.randomUUID().toString().replace("-", "");
    }

}
