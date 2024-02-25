package com.microservice.parkingService.domains;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ParkingBuilding {
    private String nameOfParkingLot;
    private ParkingLotAddress address;
    private List<ParkingFloor> parkingFloors;

    private static ParkingBuilding parkingBuilding;
    private ParkingBuilding(String nameOfParkingLot, ParkingLotAddress address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingBuilding getInstance(String nameOfParkingLot, ParkingLotAddress address, List<ParkingFloor> parkingFloors){
        synchronized (ParkingBuilding.class) {
            if (parkingBuilding == null) {
                parkingBuilding = new  ParkingBuilding(nameOfParkingLot, address, parkingFloors);
            }
        }

        return parkingBuilding;
    }
    public static ParkingBuilding getInstance(){
        return parkingBuilding;
    }

}
