package sad.system;

import java.util.Calendar;
import java.util.List;

import sad.system.plane.Plane;

public class Flight {
	
	private String flightNo;
	private String departLocation;
	private String arriveLocation;
	private Calendar departTime;
	private Calendar arriveTime;
	private double fare;
	private Plane plane;
	private List<Ticket> tickets;

	public Flight(String flightNo, String departLocation,
			String arriveLocation, Calendar departTime, Calendar arriveTime,
			double fare, Plane plane, List<Ticket> tickets) {
		super();
		this.flightNo = flightNo;
		this.departLocation = departLocation;
		this.arriveLocation = arriveLocation;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.fare = fare;
		this.plane = plane;
		this.tickets = tickets;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public String getDepartLocation() {
		return departLocation;
	}

	public String getArriveLocation() {
		return arriveLocation;
	}

	public void setDepartLocation(String departLocation) {
		this.departLocation = departLocation;
	}

	public void setArriveLocation(String arriveLocation) {
		this.arriveLocation = arriveLocation;
	}

	public Calendar getDepartTime() {
		return departTime;
	}

	public void setDepartTime(Calendar departTime) {
		this.departTime = departTime;
	}

	public Calendar getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Calendar arriveTime) {
		this.arriveTime = arriveTime;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}
	
	public String toString(){
		return flightNo + departLocation + departTime.getTime() + arriveLocation + arriveTime.getTime();
	}
}
