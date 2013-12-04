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
		airline.setTerms(tacs);
		//adding flights
		List<Flight> flights = new LinkedList<>();
		for(int i = 0; i < 700; i++){
			//flight Number
			String flightNo = "WAA000" + (i%2 + 1);
			//depart & arrival Location & time
			String departLocation;
			Calendar d_cal = Calendar.getInstance();
			Calendar a_cal = Calendar.getInstance();
			String arriveLocation;
			int year = (340+i <= 365)? 2013: 2014;
			if(i%2 == 0){
				departLocation = "WAT";
				arriveLocation = "KIX";
				d_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				d_cal.set(Calendar.YEAR, year);
				a_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+2);
				a_cal.set(Calendar.YEAR, year);
			}else{
				departLocation = "WAT";
				arriveLocation = "KIX";
				d_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				d_cal.set(Calendar.YEAR, year);
				a_cal.set(Calendar.DAY_OF_YEAR, ((339+i)%365)+1);
				a_cal.set(Calendar.YEAR, year);
			}
			//add to list
			Flight flight = new Flight(flightNo, departLocation, arriveLocation,
					d_cal, a_cal, 2000, PlaneBuilder.SmallPlaneBuilder(), new LinkedList<Ticket>());
			flights.add(flight);
			System.out.println(flight);
		}
		airline.setFlights(flights);
		return airline;
	}

}
