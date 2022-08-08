package io.github.moaresoliveira.cloudparking.repository;


import io.github.moaresoliveira.cloudparking.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, String> {
}

