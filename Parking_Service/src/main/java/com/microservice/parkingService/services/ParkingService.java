package com.microservice.parkingService.services;


import com.microservice.parkingService.domains.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ParkingService {
    public String fetchParkingSlot(String vehicleType) throws Exception {
        String  parkingSlotName =this.getParkingSlotForVehicleAndPark(vehicleType);
        return parkingSlotName;
    }

    private String getParkingSlotForVehicleAndPark(String vehicle) throws Exception {
        String parkingSlotName = StringUtils.EMPTY;
        List<ParkingFloor> parkingFloors = ParkingBuilding.getInstance().getParkingFloors();
        ParkingSlot parkingSlot=null;
        for(ParkingFloor floor : parkingFloors){
            parkingSlot = this.getRelevantSlotForVehicleAndPark(vehicle,floor);
            int slotNo = ParkingAllocationPerFloor.valueOf(vehicle).getAllocationInFloor();
            if(slotNo>=1) {
                parkingSlotName = parkingSlot.name +"-"+floor.getFloorName() + "+"+slotNo;
                ParkingAllocationPerFloor.valueOf(vehicle).setCurrentAllocationInFloor(slotNo -1);
                break;
            }else{
                throw new Exception("All Slots are full for the current Vehicle Type---"+vehicle);
            }
        }
        return parkingSlotName;
    }


    public ParkingSlot getRelevantSlotForVehicleAndPark(String vehicleType, ParkingFloor floor) throws Exception {
        ParkingSlotType parkingSlotType = pickCorrectParkingSlotType(vehicleType);
        if(null ==parkingSlotType ){
            throw new Exception("Please check the Vehicle type!.. Vehicle not supported");
        }
        Map<String,ParkingSlot> relevantParkingSlot = floor.getParkingSlotsMap().get(parkingSlotType);
        ParkingSlot slot =null ;
        for(Map.Entry<String,ParkingSlot> m : relevantParkingSlot.entrySet()){
            if(m.getValue().isAvailable) {
                slot = m.getValue();
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectParkingSlotType(String vehicleType) throws Exception {
        try {
            return ParkingSlotType.valueOf(vehicleType);
        }catch (IllegalArgumentException exception){
            throw new Exception("Please check the Vehicle type!.. Vehicle not supported");
        }
    }

    public void releaseParkingForVehicle(String vehicleType) {

    }

}
