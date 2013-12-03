package system;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import system.plane.PlaneBuilder;

public class AirlineBuilder {

	public static Airline setupAirline(Airline airline){
		airline.setCompanyName("Waterford Airline");
		airline.setLocation("Waterford");
		airline.setTick(new LinkedList<Ticket>());
		//terms and conditions
		List<TermsAndConditions> tacs = new LinkedList<TermsAndConditions>();
		tacs.add(new TermsAndConditions(true, 0.0, 1.0, 0.0));
		tacs.add(new TermsAndConditions(true, 0.4, 1.0, 500));
		tacs.add(new TermsAndConditions(false, 0.6, 0.0, 0.0));
		//adding flights
		List<Flight> flights = new LinkedList<>();
		for(int i = 0; i < 700; i++){
			Flight flight = new Flight();
			//flight Number
			flight.setFlightNo("WAA000" + (i%2 + 1));
			//depart & arrival Location & time
			int year = (340+i <= 365)? 2013: 2014;
			if(i%2 == 0){
				flight.setDepartLocation("WAT");
				flight.setArriveLocation("KIX");
				Calendar d_cal = Calendar.getInstance();
				d_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				d_cal.set(Calendar.YEAR, year);
				flight.setDepartTime(d_cal);
				Calendar r_cal = Calendar.getInstance();
				r_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+2);
				r_cal.set(Calendar.YEAR, year);
				flight.setArriveTime(r_cal);
				flight.setDepartTime(r_cal);				
			}else{
				flight.setArriveLocation("WAT");
				flight.setDepartLocation("KIX");
				Calendar d_cal = Calendar.getInstance();
				d_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				d_cal.set(Calendar.YEAR, year);
				flight.setDepartTime(d_cal);
				Calendar r_cal = Calendar.getInstance();
				r_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				r_cal.set(Calendar.YEAR, year);
				flight.setArriveTime(r_cal);
				flight.setDepartTime(r_cal);				
			}
			//fare
			flight.setFare(2000.00);
			//TODO make plane
			flight.setPlane(PlaneBuilder.SmallPlaneBuilder());
			//set emptylist to tickets in Flight
			flight.setTickets(new LinkedList<Ticket>());
			//add to list
			flights.add(flight);
			System.out.println(flight);
		}
		airline.setFlights(flights);
		return airline;
	}

}
