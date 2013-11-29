package system.plane;

public abstract class Place {
	
	private boolean vacant;
	private boolean checkIn;
	private double price;
	private Plane plane;

	public boolean isVacant() {
		return vacant;
	}

	public void setVacant(boolean vacant) {
		this.vacant = vacant;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isCheckIn() {
		return checkIn;
	}

	public void setCheckIn(boolean checkIn) {
		this.checkIn = checkIn;
	}
	
	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public void checkIn(){
		setCheckIn(true);
	}
	
	public void cancelCheckIn(){
		setCheckIn(false);
	}
}
