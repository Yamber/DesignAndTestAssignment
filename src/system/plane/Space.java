package system.plane;

public class Space extends Place{
	
	private double weight;
	
	public Space (boolean vacant, double weight){
		
		super(vacant);
		
		this.setWeight(weight);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
