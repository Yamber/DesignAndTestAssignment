package system.plane;

public abstract class Seat extends Place {
	
	private int seatNo;
	
	public Seat (boolean vacant, int seatNo){
		
		super(vacant);
		
		this.seatNo = seatNo;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

}
