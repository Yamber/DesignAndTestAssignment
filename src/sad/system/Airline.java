package sad.system;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import sad.system.customer.Customer;
import sad.system.plane.Place;
import sad.system.plane.Space;

public class Airline {
	
	private String companyName;
	private String location;
	private List<Ticket> tickets;
	private List<TermsAndConditions> terms;
	private List<Flight> flights;
	private List<Customer> customers;

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTick(List<Ticket> tickets) {
		this.tickets = tickets;
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


	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<TermsAndConditions> getTerms() {
		return terms;
	}

	public void setTerms(List<TermsAndConditions> terms) {
		this.terms = terms;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	private Ticket verify(String ticketNumber) {
		for(Ticket t: tickets){
			if(t.getTicketNo() == ticketNumber){
				return t;
			}
		}
		return null;
	}
	
	public List<Flight> searchFlights(String departLocation, String arriveLocation, Calendar departTime, int diff){
		System.out.println("Seaching flight: " + departLocation + arriveLocation + departTime);
		List<Flight> list = new LinkedList<>();
		for(Flight f: flights){
			if(f.getDepartLocation().equals(departLocation) && f.getArriveLocation().equals(arriveLocation) 
					&& f.getDepartTime().get(Calendar.YEAR) == departTime.get(Calendar.YEAR)
					&& Math.abs(f.getDepartTime().get(Calendar.DAY_OF_YEAR) - departTime.get(Calendar.DAY_OF_YEAR)) <= diff){
				list.add(f);
				System.out.println("hit: "+ f);
			}
		}
		return list;
	}
	
	//TODO chooseFlight(Flight flight) //why return Ticket?
	
	public void storeTicket(Ticket ticket){
		tickets.add(ticket);
		ticket.getFlight().getTickets().add(ticket);
		//TODO how customer store ticket?
	}

	public double calculateFare(TermsAndConditions tac, Flight flight, Place place){
<<<<<<< HEAD
		return flight.getFare() - tac.getDiscountRate() * (flight.getFare() + place.getPrice());
=======
		if (tac.getDiscountRate() == 0){
			return (flight.getFare() + place.getPrice());
		}
		else{
			
			return tac.getDiscountRate() * (flight.getFare() + place.getPrice());
		}
		
>>>>>>> 675b34ceda30cb30edb7a6450788d4caec52e75d
	}

	public double calculateCancellationFee(TermsAndConditions tac){
		return tac.getAdministrativeFee();
	}
	
	public Ticket issueTicket(Flight flight, Place place, TermsAndConditions tac, Customer customer){
		//TODO no constructor defined, need to define.
		Ticket ticket = new Ticket(calculateFare(tac, flight, place), this, customer, tac, flight, place);
		place.setVacant(false);
		tickets.add(ticket);
		customer.addTicket(ticket);
		return ticket;
	}
	
	public void cancelTicket(String ticketNumber){
		for(Ticket ticket: tickets){
			if(ticket.getTicketNo().equals(ticketNumber)){
				ticket.getPlace().cancelCheckIn();
				ticket.getPlace().setVacant(true);
				ticket.getFlight().getTickets().remove(ticket);
				ticket.getCust().getTick().remove(ticket);
				tickets.remove(ticket);
				break;
			}
		}
	}
	
	public List<Place> chooseFlight(Flight flight) throws Exception{
		int i = flights.indexOf(flight);
		System.out.println(i);
		if (i >= 0){
			Flight f = flights.get(i);
			return f.getPlane().getPlaces();
		}
		throw new Exception("There is no such Flight");	
	}
}
