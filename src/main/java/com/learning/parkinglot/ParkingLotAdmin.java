package com.learning.parkinglot;



public interface ParkingLotAdmin {
	
	public ParkingLot createParkingLot(String name, String address);
	public void addParkingFloors(ParkingFloor f);
	public void removeParkingFloor(String floorID);
	

}
