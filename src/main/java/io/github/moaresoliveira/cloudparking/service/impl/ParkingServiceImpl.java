package io.github.moaresoliveira.cloudparking.service.impl;

import io.github.moaresoliveira.cloudparking.model.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.form.ParkingForm;
import io.github.moaresoliveira.cloudparking.model.mapper.ParkingMapper;
import io.github.moaresoliveira.cloudparking.exception.ParkingNotFoundException;
import io.github.moaresoliveira.cloudparking.model.Parking;
import io.github.moaresoliveira.cloudparking.repository.ParkingRepository;
import io.github.moaresoliveira.cloudparking.service.ParkingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {
    private final ParkingMapper parkingMapper;

    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingMapper parkingMapper, ParkingRepository parkingRepository) {
        this.parkingMapper = parkingMapper;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<ParkingDTO> getAll() {
        List<Parking> parking = parkingRepository.findAll();
        return parkingMapper.toDTO(parking);
    }

    @Override
    public ParkingDTO getById(String id) {
        Parking parking = getParking(id);
        return parkingMapper.toDTO(parking);
    }

    @Override
    public ParkingDTO save(ParkingForm form) {
        String uuid = getUUID();
        Parking parking = parkingMapper.toEntity(form);
        parking.setId(uuid);
        parking.setEntryDate(LocalDateTime.now());
        return persistParking(parking);
    }

    @Override
    public ParkingDTO update(String id, ParkingForm form) {
        Parking parking = getParking(id);
        parking.setColor(form.getColor());
        parking.setModel(form.getModel());
        parking.setState(form.getState());
        parking.setLicense(form.getLicense());
        return persistParking(parking);
    }

    @Override
    public void delete(String id) {
        Parking parking = getParking(id);
        parkingRepository.delete(parking);
    }

    @Override
    public ParkingDTO exitParking(String id) {
        Parking parking = getParking(id);;
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(getBill(parking));
        return persistParking(parking);
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private Parking getParking(String id) {
        return parkingRepository.findById(id)
                .orElseThrow(() -> new ParkingNotFoundException(id));
    }

    private ParkingDTO persistParking(Parking parking) {
        Parking save = parkingRepository.save(parking);
        return parkingMapper.toDTO(save);
    }

    private double getBill(Parking parking) {
        return parking.getEntryDate().until(parking.getExitDate(), ChronoUnit.HOURS) * 0.75;
    }

}
