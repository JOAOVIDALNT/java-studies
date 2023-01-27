package com.api.parkingcontrol.Repositories;

import com.api.parkingcontrol.Models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // não necessita anotar pois o extensão jparepository ja aplica
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>
{ // recebe como parâmetro o model e o identificador
}
