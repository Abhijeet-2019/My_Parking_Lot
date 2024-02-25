package com.microservice.parkingService.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Vehicle {

    String vehicleNumber;
    VehicleType vehicleType;
}