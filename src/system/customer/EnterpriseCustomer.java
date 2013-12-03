package system.customer;


public class EnterpriseCustomer extends Customer {
	
	private String businessName;
	private double discountRate;

	public EnterpriseCustomer(String name) {
		super(name);
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
