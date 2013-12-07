package sad.system.plane;

public class Seat extends Place {
	private String seatNumber;
	
	public Seat(String seatNumber, double price, Plane plane){
		super(seatNumber, price, plane);
		price = 0;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}
