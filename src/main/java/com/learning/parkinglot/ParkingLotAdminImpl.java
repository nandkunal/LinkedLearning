package com.learning.parkinglot;

public class ParkingLotAdminImpl implements ParkingLotAdmin {

	@Override
	public ParkingLot createParkingLot(String name, String address) {
		
		return new ParkingLot("test","testAddress");
	}

	@Override
	public void addParkingFloors(ParkingFloor f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeParkingFloor(String floorID) {
		// TODO Auto-generated method stub
		
	}

}
