package com.microservice.parkingService.controller;


import com.microservice.parkingService.services.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    /**
     * This method is used to Fetch a desired Parking Spot for a Vehicle.
     * @param vehicleType
     * @return
     */
    @GetMapping("/fetchParkingSlot")
    public String fetchParkingSlot(String vehicleType){
        log.info("Started Fetching Parking Slot for Vehicle Type -- {}", vehicleType);
        String nameOfParkingSlot = null;
        try {
            nameOfParkingSlot = parkingService.fetchParkingSlot(vehicleType);
        } catch (Exception e) {
            log.info("Parking slot is not defined for the Vehicle Type--> {}",vehicleType);
            nameOfParkingSlot = e.getMessage().toString();
        }
        log.info("The allocated Parking Slot is -- {}", nameOfParkingSlot);
        return nameOfParkingSlot;
    }

    /**
     * This method is used to release a desired Parking Spot for a Vehicle
     * @param allocatedSlot
     * @return
     */
    public String releaseParkingOfVehicle(String allocatedSlot){
        parkingService.releaseParkingForVehicle(allocatedSlot);
        return "Parking Release for Slot";
    }
}
