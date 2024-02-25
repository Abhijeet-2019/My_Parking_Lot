package com.microservice.parkingService.domains;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ParkingLotAddress {
    String street;
    String block;
    String city;
    String state;
    String country;
}
