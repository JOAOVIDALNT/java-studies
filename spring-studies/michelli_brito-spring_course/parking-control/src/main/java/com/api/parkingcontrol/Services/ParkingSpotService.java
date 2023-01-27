package com.api.parkingcontrol.Services;

import com.api.parkingcontrol.Models.ParkingSpotModel;
import com.api.parkingcontrol.Repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// camada intermediária entre controller e repository
// controller aciona o service e service aciona o repository
@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    /*
    O CONSTRUTOR SUBSTITUI A ANOTAÇÃO @Autowired

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    */
    @Transactional // garante o rollback
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
}
