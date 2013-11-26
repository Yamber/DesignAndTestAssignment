package system;

import system.customer.Customer;

public class Ticket {
	
	private int ticketNo;
	private double price;
	private Airline air;
	private Customer cust;
	
	public Ticket(int ticketNo, double price){
		
		 this.ticketNo = ticketNo;
		 this.price = price;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public Airline getAir() {
		return air;
	}

	public void setAir(Airline air) {
		this.air = air;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
