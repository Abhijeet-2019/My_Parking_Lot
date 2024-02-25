package com.microservice.parkingService.domains;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ParkingSlot {

    public String name;
    public ParkingSlotType parkingSlotType;
    @Builder.Default
    public boolean isAvailable = true;
}
