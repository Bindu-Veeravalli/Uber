package com.uberbooking.model;

public class Driver {
	
	String name;
	int age;
	Vehicle vehicle;
	boolean isBooked = false;
	
	public Driver() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", age=" + age + ", vehicle=" + vehicle + ", isBooked=" + isBooked + "]";
	}
	
}
