package system.customer;


public class EnterpriseCustomer extends Customer {
	
	private String businessName;
	private double discountRate;

	public EnterpriseCustomer(String name, String businessName, double discountRate) {
		
		super(name);
		
		this.businessName = businessName;
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	

}
