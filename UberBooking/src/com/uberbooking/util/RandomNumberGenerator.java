package com.uberbooking.util;

public class RandomNumberGenerator {
	
	public static int generateId() {
		
		return (int) (Math.random()*100 + 1);
		
	}

}
