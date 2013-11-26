package system.plane;

public abstract class Place {
	
	private boolean vacant;
	private double price;
	
	public Place (boolean vacant){
		
		this.setVacant(vacant);
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
}
