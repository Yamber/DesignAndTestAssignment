package system.customer;

import java.util.List;

import system.Ticket;

public abstract class Customer {
	
	private String name;
	private List<Ticket> ticket;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ticket> getTick() {
		return ticket;
	}
	public void setTick(List<Ticket> ticket) {
		this.ticket = ticket;
	}

}
