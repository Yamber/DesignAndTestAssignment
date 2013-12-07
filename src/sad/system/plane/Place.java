package sad.system.plane;

public abstract class Place {
	
	protected String placeNo;
	protected boolean vacant;
	protected boolean checkIn;
	protected double price;
	
	public Place(String placeNo, double price, Plane plane) {
		super();
		this.placeNo = placeNo;
		this.vacant = true;
		this.checkIn = false;
		this.price = price;
		plane.getPlaces().add(this);
	}

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
	
	public String getPlaceNo() {
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}

	public void checkIn(){
		setCheckIn(true);
	}
	
	public void cancelCheckIn(){
		setCheckIn(false);
	}
	
	@Override
	public boolean equals(Object o){
		Place p = (Place) o;
		return placeNo.equals(p.getPlaceNo());
	}
	
}
