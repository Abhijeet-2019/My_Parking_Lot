package com.microservice.parkingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * This is the main class of Parking Service
 * Swagger URL : http://localhost:8080/swagger-ui/index.html#
 */
public class ParkingServiceAppMain {
    public static void main(String[] args) {
        System.out.println("Starting Parking Service");
        SpringApplication.run(ParkingServiceAppMain.class);
        System.out.println("Starting Parking Started");
    }
}