package system;

public class TermsAndConditions {
	private boolean cancellable;
	private float discountRate;
	private float refoundRate;
	private double administrativeFee;
	
	public double getAdministrativeFee() {
		return administrativeFee;
	}
	
	public void setAdministrativeFee(double administrativeFee) {
		this.administrativeFee = administrativeFee;
	}

	public boolean isCancellable() {
		return cancellable;
	}

	public void setCancellable(boolean cancellable) {
		this.cancellable = cancellable;
	}

	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public float getRefoundRate() {
		return refoundRate;
	}

	public void setRefoundRate(float refoundRate) {
		this.refoundRate = refoundRate;
	}
	
	
	
}
