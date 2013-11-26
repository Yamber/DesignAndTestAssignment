package system.customer;

import system.Airline;
import system.Ticket;

public abstract class Customer {
	
	private String name;
	private Ticket tick;
	private Airline air;
	
	public Customer(String name){
		
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ticket getTick() {
		return tick;
	}
	public void setTick(Ticket tick) {
		this.tick = tick;
	}
	public Airline getAir() {
		return air;
	}
	public void setAir(Airline air) {
		this.air = air;
	}

}
