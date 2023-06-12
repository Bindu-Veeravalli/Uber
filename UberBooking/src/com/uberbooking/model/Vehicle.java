package com.uberbooking.model;

public class Vehicle {
	
	String carName;
	String carNumber;
	String carType;
	
	public Vehicle() {}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "Vehicle [carName=" + carName + ", carNumber=" + carNumber + ", carType=" + carType + "]";
	}
	

}
