package system;

import java.util.LinkedList;

import system.customer.Customer;
import system.plane.Place;

public class Airline {
	
	private String companyName;
	private String location;
	private Customer cust;
	private Ticket tick;
	private LinkedList<TermsAndConditions> terms;
	private LinkedList<Flight> flights;
	
	public Airline(String companyName, String location){
		
		this.companyName = companyName;
		this.location = location;
		
		setFlights(new LinkedList<Flight>());
		setTerms(new LinkedList<TermsAndConditions>());
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public Ticket getTick() {
		return tick;
	}

	public void setTick(Ticket tick) {
		this.tick = tick;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public LinkedList<Flight> getFlights() {
		return flights;
	}

	public void setFlights(LinkedList<Flight> flights) {
		this.flights = flights;
	}

	public LinkedList<TermsAndConditions> getTerms() {
		return terms;
	}

	public void setTerms(LinkedList<TermsAndConditions> terms) {
		this.terms = terms;
	}
	
	private double calculateFare(TermsAndConditions tac, Flight flight, Place place){
		return tac.getDiscountRate() * (flight.getFare() + place.getPrice());
	}

	private double calculateCancellationFee(TermsAndConditions tac, Flight flight, Place place){
		return tac.getAdministrativeFee();
	}
}
