package sad.system.gui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import sad.system.Flight;

public class FlightTableModel extends DefaultTableModel {
	List<Flight> flights = new ArrayList<>();
	Class[] columnTypes = new Class[] {String.class, Calendar.class, String.class, Calendar.class, Double.class};

	public FlightTableModel() {
		super(new Object[][] {}, new String[] {"Departure", "Departure Time", "Destination", "Arrival Time", "Fare"});
	}
	
	@Override
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
	
	public void addRow(Object[] rowData, Flight flight){
		addRow(rowData);
		flights.add(flight);
	}

	public Flight getFlight(int i){
		return flights.get(i);
	}
}
