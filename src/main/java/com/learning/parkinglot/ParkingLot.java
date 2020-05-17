package com.learning.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
	
	private String parkingLotID;
	 private String parkingLotName;
	 private String parkingLotAddress;
	private  List<ParkingFloor> parkingFloors;
	
	public ParkingLot(String parkingLotName, String parkingLotAddress) {
		this.parkingLotName = parkingLotName;
		this.parkingLotAddress = parkingLotAddress;
		parkingFloors = new ArrayList<>();
		parkingLotID = UUID.randomUUID().toString();
		
	}
	public String getParkingLotID() {
		return parkingLotID;
	}

	public String getParkingLotName() {
		return parkingLotName;
	}
	
	public String getParkingLotAddress() {
		return parkingLotAddress;
	}
	
	public List<ParkingFloor> getParkingFloors() {
		return parkingFloors;
	}
	
	

	
	
	

}
