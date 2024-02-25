package com.microservice.parkingService.domains;

public enum ParkingAllocationPerFloor {
    TwoWheeler {
        int allocation = 10;
        public int getAllocationInFloor() {
            return allocation;
        }
        public void setCurrentAllocationInFloor( int allocatedSlot){
            allocation = allocatedSlot;
        }
    },
    CompactCars {
        int allocation = 5;
        public int getAllocationInFloor() {
            return allocation;
        }
        public void setCurrentAllocationInFloor( int allocatedSlot){
            allocation = allocatedSlot;
        }
    },
    Sedan {
        int allocation = 5;
        public int getAllocationInFloor() {
            return allocation;
        }
        public void setCurrentAllocationInFloor( int allocatedSlot){
            allocation = allocatedSlot;
        }
    },
    SUVCars {
        int allocation = 5;
        public int getAllocationInFloor() {
            return allocation;
        }
        public void setCurrentAllocationInFloor( int allocatedSlot){
            allocation = allocatedSlot;
        }
    },
    LargeTrucks {
        int allocation = 5;
        public int getAllocationInFloor() {
            return allocation;
        }
        public void setCurrentAllocationInFloor( int allocatedSlot){
            allocation = allocatedSlot;
        }
    };

    public abstract int getAllocationInFloor();
    public abstract void setCurrentAllocationInFloor(int allocation);



}
