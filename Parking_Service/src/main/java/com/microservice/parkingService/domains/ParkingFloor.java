package com.microservice.parkingService.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Getter
@Setter
@Builder
public class ParkingFloor {
    private String floorName;
    private Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlotsMap;

    public void addParkingSlotsInFloors( Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlot){
        parkingSlotsMap.putAll(parkingSlot);
    }

}
