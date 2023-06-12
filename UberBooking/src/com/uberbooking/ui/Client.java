package com.uberbooking.ui;

import java.util.Scanner;

import com.uberbooking.dao.CustomerDao;
import com.uberbooking.dao.DriverDao;
import com.uberbooking.model.Customer;
import com.uberbooking.model.Driver;
import com.uberbooking.model.Vehicle;
import com.uberbooking.util.RandomNumberGenerator;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		//Switch Case for Registration
		while(true) {
			
			System.out.println("\nWelcome to Uber\n");
			System.out.println("1. Register as a Driver");
			System.out.println("2. Register as a User");
			System.out.println("3. Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					Driver driver = new Driver();
					
					System.out.println("Enter name :");
					sc.nextLine();
					String name = sc.nextLine();
					driver.setName(name);
					
					System.out.println("Enter age :");
					int age = sc.nextInt();
					driver.setAge(age);
					
					Vehicle vehicle = new Vehicle();
					driver.setVehicle(vehicle);
					
					System.out.println("Enter car name :");
					sc.nextLine();
					String carName = sc.nextLine();
					driver.getVehicle().setCarName(carName);
					
					System.out.println("Enter car number :");
					driver.getVehicle().setCarNumber(sc.nextLine());
					
					System.out.println("Select Car Type :\n1. Uber Mini\n2. Uber Sedan");
					int carType = sc.nextInt();
					if(carType==1) driver.getVehicle().setCarType("Uber Mini");
					else driver.getVehicle().setCarType("Uber Sedan");
					
					int driverId = RandomNumberGenerator.generateId();
					
					DriverDao.driverMap.put(driverId, driver);
					
//					System.out.println(driver);
					
					System.out.println("Driver " + driver.getName() + " with id "+driverId+" created");
					continue;
			
				case 2:
					Customer customer = new Customer();
					
					System.out.println("Enter name: ");
					sc.nextLine();
					customer.setName(sc.nextLine());
					
					System.out.println("Enter phone number: ");
					customer.setPhoneNumber(sc.nextLong());
					
					int customerId = RandomNumberGenerator.generateId();
					
					CustomerDao.customerMap.put(customerId, customer);
					
					System.out.println("Customer "+customer.getName()+" with id "+customerId+" created");
				
					continue;
					
				default:
					break;
			}
			break;
		}
		
		
		//Switch Case for booking and viewing details
		while(true) {
			System.out.println("\n1. View Customer Details");
			System.out.println("2. View Driver Details");
			System.out.println("3. Book a ride");
			System.out.println("4. Make Payment");
			System.out.println("5. Exit");
			
			int option = sc.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Enter id: ");
					int customerId = sc.nextInt();
					System.out.println(CustomerDao.customerMap.get(customerId));
					continue;
				
				case 2:
					System.out.println("Enter id: ");
					int driverId = sc.nextInt();
					System.out.println(DriverDao.driverMap.get(driverId));
					continue;
				
				case 3:
					System.out.println("Enter id: ");
					int bookingCustomerId = sc.nextInt();
					Customer customer = CustomerDao.customerMap.get(bookingCustomerId);
					boolean bookedStatus = false;
					for(Driver driver : DriverDao.driverMap.values()) {
						if(!driver.isBooked()) {
							customer.setDriver(driver);
							driver.setBooked(true);
							System.out.println("Your ride has been booked\n");
							System.out.println("Here are your ride details : \n");
							System.out.println("Driver Name: "+customer.getDriver().getName());
							System.out.println("Car Name :"+customer.getDriver().getVehicle().getCarName());
							System.out.println("Car Number: "+customer.getDriver().getVehicle().getCarNumber());
							System.out.println("Drive Type: "+customer.getDriver().getVehicle().getCarType());
							System.out.println("Total Due: "+Math.random()*1000);
							bookedStatus = true;
						}
					}
					if(!bookedStatus) System.out.println("No Ride available at the moment");
					continue;
					
				case 4:
					System.out.println("Enter your id: ");
					int paymentCustomerId = sc.nextInt();
					Customer payingCustomer = CustomerDao.customerMap.get(paymentCustomerId);
					payingCustomer.getDriver().setBooked(false);
					System.out.println("Payment Done");
					continue;
				
				default:
					break;
			}
			break;
		}
		
	}

}
