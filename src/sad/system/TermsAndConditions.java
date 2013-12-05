package sad.system;

public class TermsAndConditions {
	private boolean cancellable;
	private double discountRate;
	private double refoundRate;
	private double administrativeFee;

	public TermsAndConditions(boolean cancellable, double discountRate,
			double refoundRate, double administrativeFee) {
		super();
		this.cancellable = cancellable;
		this.discountRate = discountRate;
		this.refoundRate = refoundRate;
		this.administrativeFee = administrativeFee;
	}

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

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public double getRefoundRate() {
		return refoundRate;
	}

	public void setRefoundRate(double refoundRate) {
		this.refoundRate = refoundRate;
	}
	
	public String toString(){
		return "Cancellable " + booleanToYesNo(cancellable) +
				"\nDiscount Rate " + doubleToPercentage(discountRate) +
				"\nAdministrative Fee for Cancel and Changing " + administrativeFee;
	}
	
	private String booleanToYesNo(boolean b){
		return (b)? "yes": "no";
	}
	
	private String doubleToPercentage(double d){
		return ((int) (d * 100)) + "%";
	}
	
	
}
