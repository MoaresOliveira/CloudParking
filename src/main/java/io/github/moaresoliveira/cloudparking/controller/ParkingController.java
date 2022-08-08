package io.github.moaresoliveira.cloudparking.controller;

import io.github.moaresoliveira.cloudparking.model.dto.ParkingDTO;
import io.github.moaresoliveira.cloudparking.model.form.ParkingForm;
import io.github.moaresoliveira.cloudparking.service.ParkingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking Controller", description = "Parking operations")
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    @Operation(summary = "Get all parkings")
    public ResponseEntity<List<ParkingDTO>> getAll() {
        List<ParkingDTO> parkingDTOList = parkingService.getAll();
        return parkingDTOList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(parkingDTOList);
    }

     @GetMapping("/{id}")
        @Operation(summary = "Get parking by id")
    public ResponseEntity<ParkingDTO> getById(String id) {
         ParkingDTO parkingDTO = parkingService.getById(id);
         return ResponseEntity.ok(parkingDTO);
    }

    @PostMapping
    @Operation(summary = "Save parking")
    public ResponseEntity<ParkingDTO> save(@RequestBody ParkingForm form) {
        ParkingDTO parkingDTO = parkingService.save(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete parking")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update parking")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingForm form) {
        ParkingDTO parkingDTO = parkingService.update(id, form);
        return ResponseEntity.ok(parkingDTO);
    }

    @PostMapping("/{id}")
    @Operation(summary = "Exit parking")
    public ResponseEntity<ParkingDTO> exitParking(@PathVariable String id) {
        ParkingDTO parkingDTO = parkingService.exitParking(id);
        return ResponseEntity.ok(parkingDTO);
    }
}
