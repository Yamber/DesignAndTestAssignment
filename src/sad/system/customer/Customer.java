package sad.system.customer;

import java.util.LinkedList;
import java.util.List;

import sad.system.Ticket;

public abstract class Customer {
	
	private String name;
	private List<Ticket> tickets;
	
	public Customer(String name) {
		this.name = name;
		tickets = new LinkedList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ticket> getTick() {
		return tickets;
	}
	public void setTick(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public void addTicket(Ticket ticket){
		tickets.add(ticket);
	}
	
	public Ticket getTicket(int index){
		return tickets.get(index);
	}

}
