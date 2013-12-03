package system.plane;

public class Seat extends Place {
	private String seatNumber;
	
	public Seat(String seatNumber, Plane plane){
		this.seatNumber = seatNumber;
		this.plane = plane;
		vacant = true;
		checkIn = false;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
