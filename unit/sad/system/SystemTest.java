package sad.system;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sad.system.customer.PersonalCustomer;
import sad.system.plane.Place;
import sad.system.plane.Plane;
import sad.system.plane.PlaneBuilder;
import sad.system.plane.Seat;

public class SystemTest {

	private Flight flightA;
	private Flight flightB;
	private Flight flightC;

	private TermsAndConditions tac1;
	private TermsAndConditions tac2;
	private TermsAndConditions tac3;

	private Ticket tickA;
	private Ticket tickB;
	private Ticket tickC;
	
	private List<Ticket> ticks;

	private PersonalCustomer custA;
	private PersonalCustomer custB;
	private PersonalCustomer custC;

	private Seat seat1;
	private Seat seat2;
	private Seat seat3;

	private Plane planeA;
	private Plane planeB;
	private Plane planeC;

	private List<Flight> flights;

	private Airline airline;


	@Before
	public void setUp(){
		
		custA = new PersonalCustomer("Bill");
		custB = new PersonalCustomer("Nicola");
		custC = new PersonalCustomer("Pat");
		
		planeA = PlaneBuilder.SmallPlaneBuilder();
		planeB = PlaneBuilder.SmallPlaneBuilder();
		planeC= PlaneBuilder.SmallPlaneBuilder();
		
		seat1 = new Seat("A3", 0, planeA);
		seat2 = new Seat("J8", 0, planeB);
		seat3 = new Seat("J7", 0, planeC);
			
		tac1 = new TermsAndConditions(false, 0.0, 1.0, 0.0);
		tac2 = new TermsAndConditions(true, 0.4, 1.0, 500);
		tac3 = new TermsAndConditions(false, 0.6, 0.0, 0.0);
		
		Calendar d_cal1 = Calendar.getInstance();
		Calendar a_cal1 = Calendar.getInstance();
		Calendar d_cal2 = Calendar.getInstance();
		Calendar a_cal2 = Calendar.getInstance();
		Calendar d_cal3 = Calendar.getInstance();
		Calendar a_cal3 = Calendar.getInstance();
		
		d_cal1.set(134, 2013);
		a_cal1.set(145, 2013);
		d_cal2.set(345, 2013);
		a_cal2.set(2, 2014);
		d_cal3.set(15, 2014);
		a_cal3.set(56, 2014);
		
		flightA = new Flight("WA134", "WAT", "KIX", d_cal1, a_cal2, 1500, planeA, new LinkedList<Ticket>());
		flightB = new Flight("WA456", "DUB", "LON", d_cal2, a_cal2, 125, planeB, new LinkedList<Ticket>());
		flightC = new Flight("WA934", "PAR", "BOS", d_cal3, a_cal3, 980, planeC, new LinkedList<Ticket>());
		
		tickA = new Ticket(1500, airline, custA, tac1, flightA, seat1);
		tickB = new Ticket(125, airline, custB, tac2, flightB, seat2);
		tickC = new Ticket(980, airline, custC, tac3, flightC, seat3);
		
		ticks.add(tickA);
		ticks.add(tickB);
		ticks.add(tickC);
		
		airline = new Airline();
		
		flights.add(flightA);
		flights.add(flightB);
		flights.add(flightC);
		
		airline.setFlights(flights);
		airline.setTick(ticks);
	}
	    
    
	@Test
	public void listFlights(){
		Calendar d_cal = Calendar.getInstance();
		d_cal.set(132,2013);
		List <Flight> flights = airline.searchFlights("WAT", "KIX", d_cal, 0);
		boolean found = false;
		for (Flight f : flights){
			if (f == flightA){
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
	
	@Test
	public void calculateFareTest(){
		double fare1 = airline.calculateFare(tac1, flightA, seat1);
		double fare2 = airline.calculateFare(tac2, flightB, seat2);
		double fare3 = airline.calculateFare(tac3, flightC, seat3);
		assertTrue(fare1 == 1500.0);
		assertTrue(fare2 == 124.5);
		assertTrue(fare3 == 974.12);
	}

	@Test
	public void storeTicketTest(){
		Ticket ticD = new Ticket(1500, airline, custA, tac2, flightC, seat1);
		airline.storeTicket(ticD);
	    List<Ticket> tickets = airline.getTickets();
		assertTrue(ticD == tickets.get(3));
	}
	
	@Test
	public void cancellationFeeTest(){
		double fee1 = tac1.getAdministrativeFee();
		double fee2 = tac2.getAdministrativeFee();
		tac3.setAdministrativeFee(230);
		double fee3 = tac3.getAdministrativeFee();
		assertTrue(fee1 == 0.0);
		assertTrue(fee2 == 500);
		assertTrue(fee3 == 230);
	}
	@Test
	public void cancelTicketTest(){
		String tickNo = tickA.getTicketNo();
		airline.cancelTicket(tickNo);
		assertTrue(ticks.get(0) != tickA);
		assertTrue(ticks.get(0) == tickB);
	}
	
	

}
