package system;

import system.customer.Customer;
import system.plane.Place;

public class Ticket {
	
	private String ticketNo;
	private double price;
	private Airline air;
	private Customer cust;
	private TermsAndConditions tac;
	private Flight flight;
	private Place place;
	
	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
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

	public TermsAndConditions getTac() {
		return tac;
	}

	public void setTac(TermsAndConditions tac) {
		this.tac = tac;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
	public boolean isCancellable(){
		return tac.isCancellable();
	}
	
	public void setDetail(Place place, Flight flight, TermsAndConditions tac){
		setPlace(place);
		setFlight(flight);
		setTac(tac);
	}
	

}
