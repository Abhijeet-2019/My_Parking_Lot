package com.microservice.parkingService.services;

import com.microservice.parkingService.domains.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InitializeParkingLotService implements ApplicationRunner{

    private static ParkingBuilding parkingBuilding = null;

    String nameOfParkingLot = "My Parking Lot";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Called this method to pre initialize parking Lot");
        ParkingLotAddress address = ParkingLotAddress.builder()
                .city("Bangalore")
                .country("India")
                .state("KA").build();
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsInFloor = new HashMap<>();
        ParkingFloor parkingFloor = ParkingFloor.builder()
                .floorName("Ground")
                .parkingSlotsMap(parkingSlotsInFloor)
                .build();
        createParkingSlots(parkingFloor);
        parkingFloors.add(parkingFloor);
        parkingBuilding = ParkingBuilding.getInstance(nameOfParkingLot, address, parkingFloors);
    }
    private void createParkingSlots(ParkingFloor parkingFloor) {
        ParkingSlotType[] parkingSlotTypes = ParkingSlotType.values();
        Map<ParkingSlotType, Map<String, ParkingSlot>> allSlots = new HashMap<>();
        for (ParkingSlotType parkingSlotType : parkingSlotTypes) {
            System.out.println("The parking Slot Type " + parkingSlotType);
            Map<String, ParkingSlot> slotType = new HashMap<>();
            int allocationInFloor = ParkingAllocationPerFloor.valueOf(parkingSlotType.name()).getAllocationInFloor();
            for (int i = 0; i < allocationInFloor; i++) {
                ParkingSlot slot = ParkingSlot.builder().name(parkingSlotType.name()).parkingSlotType(parkingSlotType).build();
                slotType.put(parkingSlotType.name().toString(), slot);
                allSlots.put(parkingSlotType, slotType);
            }
        }
        System.out.println("Print all Slots"+allSlots);
        parkingFloor.addParkingSlotsInFloors(allSlots);
    }
}
