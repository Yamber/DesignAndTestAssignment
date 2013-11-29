package system.plane;

public class Seat extends Place {
	private String SeatNumber;
	
	public Seat(){
		super();
	}

	public String getSeatNumber() {
		return SeatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		SeatNumber = seatNumber;
	}
	
	
}
