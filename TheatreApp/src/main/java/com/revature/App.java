package com.revature;

public class App {

	public static void main(String[] args) {

		Theatre theatre = new Theatre("Ford's Theatre", 8, 12);
		
		theatre.getSeats();
		
		
		// I want to reserve a seat.
		
		// I'll enter the seatNumber, the program will check if the seat is reserved,
		//if available the reserved boolean will turn to true
		
		theatre.reserveSeatBinary("H01");
	}

}
