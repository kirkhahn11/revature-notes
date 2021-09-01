package com.revature;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

	
	private final String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	/**
	 * When do you use an ArrayList over a LinkedList and vice versa
	 * 
	 * ArrayList:
	 * best for SEARCHING: is done in constant time O(1) 
	 * worst for INSERTING and DELETING: done in Linear time O(n)
	 * 
	 * LinkedList 
	 * Best for INSERTING and DELETING: O(1) time == constant (because LinkedList consist of nodes with addresses)
	 * Worst for: Searching sometimes O(1) other times more complex.....
	 * @param theatreName
	 * @param numRows
	 * @param seatsPerRow
	 */
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		
		this.theatreName = theatreName;
		
		int lastRow = 'A' + (numRows - 1);
		
		for(char row = 'A'; row <= lastRow; row++) {
			for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
				
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	public String getTheatreName() {
		return this.theatreName;
	}
	
	public void getSeats() {
		for(Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}
	
	// I'd like to reserve seat G07 ex
	// brute foce algorithm - check every single seat to see if this is the one I want to reserve
	public boolean reserveSeat(String seatNumber) {
		
		Seat requestedSeat = null;
		
		for(Seat seat : seats) {
			
			
			if(seat.getSeatNumber().equals(seatNumber)) {
				requestedSeat = seat;
				break;
			}
		}
		
		if (requestedSeat == null) {
			System.out.println("There is no seat " + seatNumber);
			return false;
		}
		return requestedSeat.reserve(); 
	}
	
	//Binary Reserve Seat Algorithm
	public boolean reserveSeatBinary(String seatNumber) {
		
		int low = 0; 
		int high = seats.size();
		
		while(low <= high) {
			
			System.out.println(".");
			// capture the middle value 
			int mid = (low + high) / 2;
			
			// use the middle value to capture the middle seat of the row
			Seat midVal = seats.get(mid); 
			
			// we have to check if the seatNumber provided is < or > the midVal
			int cmp = midVal.getSeatNumber().compareTo(seatNumber);
			
			// 0 if equal, -1 if less than, 1 if greater than
			
			
			if(cmp < 0) {
				low = mid + 1;
			} else if (cmp > 0) {
				high = mid -1;
			} else {
				return seats.get(mid).reserve();
			}
		}
		System.out.println("there is no seat " + seatNumber);
		return false;
	}
	
	/**
	 * Comparable is an interface that allows us to define the order of a user-defined class
	 * 
	 * @author kirkhahn
	 *
	 */
	
	private class Seat implements Comparable<Seat>{
		
		private final String seatNumber;
		private boolean reserved = false;
		
		public Seat(String seatNumber) {
			this.seatNumber = seatNumber;
		}

		public String getSeatNumber() {
			return seatNumber;
		}
		
		public boolean reserve() {
			if(!this.reserved) {
				this.reserved = true;
				
				System.out.print("Reservation of seat " + seatNumber + " reserved");
				
				return true;
			} else {
				return false; 
			}
		}

		// this is how we're define if a seat is > or < another
		@Override
		public int compareTo(Seat seat) {
			return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
		}
	}
}
