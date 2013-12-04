package sad.system;

import sad.system.customer.Customer;
import sad.system.plane.Place;

public class Ticket {
	
	private String ticketNo;
	private double price;
	private Airline air;
	private Customer customer;
	private TermsAndConditions tac;
	private Flight flight;
	private Place place;
	
	
	public Ticket(double price, Airline air, Customer customer,
			TermsAndConditions tac, Flight flight, Place place) {
		super();
		this.price = price;
		this.air = air;
		this.customer = customer;
		this.tac = tac;
		this.flight = flight;
		this.place = place;
	}

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
		return customer;
	}

	public void setCust(Customer customer) {
		this.customer = customer;
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
