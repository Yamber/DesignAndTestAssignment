package sad.system.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import sad.system.Airline;
import sad.system.AirlineBuilder;
import sad.system.Flight;
import sad.system.TermsAndConditions;
import sad.system.Ticket;
import sad.system.customer.Customer;
import sad.system.customer.PersonalCustomer;
import sad.system.plane.Place;
import sad.system.plane.Seat;

import com.toedter.calendar.JDateChooser;

import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class CustomerGui extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg;
	private JDateChooser jdcDeparting;
	private JDateChooser jdcReturning;
	private JSpinner sprDepart;
	private JSpinner sprDesti;
	private JSpinner sprClass;
	private JSpinner sprNumTicket;
	private Customer customer;
	private Airline airline;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGui frame = new CustomerGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerGui() {
		airline = AirlineBuilder.setupAirline(new Airline());
		customer = new PersonalCustomer("Tester");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 453);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblDeparting = new JLabel("Departing");
		lblDeparting.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblDeparting.setBounds(10, 57, 120, 30);
		contentPane.add(lblDeparting);
		
		jdcDeparting = new JDateChooser(new Date());
		jdcDeparting.setBounds(140, 63, 140, 24);
		jdcDeparting.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try{
					Date newDate = (Date) evt.getNewValue();
					Calendar newCal = Calendar.getInstance();
					newCal.setTime(newDate);
					Calendar oldCal = Calendar.getInstance();
					oldCal.setTime(new Date());
					if (newCal.get(Calendar.YEAR) <= oldCal.get(Calendar.YEAR)){
						if(newCal.get(Calendar.DAY_OF_YEAR) < oldCal.get(Calendar.DAY_OF_YEAR)){
							jdcDeparting.setDate((Date)evt.getOldValue());
							System.out.println("Invalid Date Detected in Departing");
						}
					}
				} catch (ClassCastException e){		
					
				}
			}
		});
		contentPane.add(jdcDeparting);
		
		JLabel lblReturning = new JLabel("Returning");
		lblReturning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblReturning.setBounds(324, 57, 120, 30);
		contentPane.add(lblReturning);
		
		jdcReturning = new JDateChooser(new Date(new Date().getTime() + 86400000));
		jdcReturning.setBounds(454, 63, 140, 24);
		jdcReturning.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				try{
					Date newDate = (Date) evt.getNewValue();
					Calendar newCal = Calendar.getInstance();
					newCal.setTime(newDate);
					Calendar oldCal = Calendar.getInstance();
					oldCal.setTime(new Date());
					if (newCal.get(Calendar.YEAR) <= oldCal.get(Calendar.YEAR)){
						if(newCal.get(Calendar.DAY_OF_YEAR) < oldCal.get(Calendar.DAY_OF_YEAR)){
							jdcReturning.setDate((Date)evt.getOldValue());
							System.out.println("Invalid Date Detected in Returning");
						}
					}
				} catch (ClassCastException e){					
				}
			}
		});
		contentPane.add(jdcReturning);

		bg = new ButtonGroup();
		
		JRadioButton rdbtnReturn = new JRadioButton("Return");
		rdbtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sprDesti.setEnabled(true);
				jdcReturning.setEnabled(true);
			}
		});
		rdbtnReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		rdbtnReturn.setBounds(10, 27, 65, 23);
		rdbtnReturn.setSelected(true);
		bg.add(rdbtnReturn);
		contentPane.add(rdbtnReturn);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One Way");
		rdbtnOneWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sprDesti.setEnabled(false);
				jdcReturning.setEnabled(false);
			}
		});
		rdbtnOneWay.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		rdbtnOneWay.setBounds(77, 27, 80, 23);
		bg.add(rdbtnOneWay);
		contentPane.add(rdbtnOneWay);
		
		sprDepart = new JSpinner();
		sprDepart.setModel(new SpinnerListModel(new String[] {"DUB", "LON", "KIX", "WAT"}));
		sprDepart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprDepart.setBounds(163, 28, 100, 20);
		contentPane.add(sprDepart);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTo.setBounds(273, 32, 20, 14);
		contentPane.add(lblTo);
		
		sprDesti = new JSpinner();
		sprDesti.setModel(new SpinnerListModel(new String[] {"DUB", "LON", "KIX", "WAT"}));
		sprDesti.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprDesti.setBounds(303, 28, 100, 20);
		contentPane.add(sprDesti);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblClass.setBounds(10, 98, 120, 30);
		contentPane.add(lblClass);
		
		sprClass = new JSpinner();
		sprClass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprClass.setModel(new SpinnerListModel(new String[] {"Economy", "Business"}));
		sprClass.setBounds(140, 107, 140, 24);
		contentPane.add(sprClass);
		
		JLabel lblNumberOfTicket = new JLabel("Number of Ticket");
		lblNumberOfTicket.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblNumberOfTicket.setBounds(324, 98, 200, 30);
		contentPane.add(lblNumberOfTicket);
		
		sprNumTicket = new JSpinner();
		sprNumTicket.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sprNumTicket.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprNumTicket.setBounds(534, 106, 60, 24);
		contentPane.add(sprNumTicket);
		
		JButton btnSearch = new JButton("Search Flight");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchFlight();
			}
		});
		btnSearch.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnSearch.setBounds(10, 139, 584, 41);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 584, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new FlightTableModel());
		scrollPane.setViewportView(table);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 605, 21);
		contentPane.add(menuBar);
		
		JMenu mnTicket = new JMenu("Ticket");
		menuBar.add(mnTicket);
		
		JMenuItem mntmShowTickets = new JMenuItem("Show Tickets");
		mntmShowTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTicket();
			}
		});
		mnTicket.add(mntmShowTickets);
		
		JMenuItem mntmCancelTickets = new JMenuItem("Cancel Tickets");
		mntmCancelTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelTicket();
			}
		});
		mnTicket.add(mntmCancelTickets);
		
		JButton btnBook = new JButton("Book Selected Flight");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = table.getSelectedRow();
				if(i >= 0){
					FlightTableModel ftm = (FlightTableModel) table.getModel();
					Flight f = ftm.getFlight(i);
					bookFlight(f);
				}
			}
		});
		btnBook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnBook.setBounds(10, 363, 584, 41);
		contentPane.add(btnBook);
	}
	
	private void searchFlight(){
		List<Flight> flights = airline.searchFlights(
				sprDepart.getValue().toString(), sprDesti.getValue().toString(), jdcDeparting.getCalendar(), 2);
		FlightTableModel ftm = (FlightTableModel) table.getModel();
		System.out.println("Flights");
		for(int i = 0; i < ftm.getRowCount(); i++){
			ftm.removeRow(0);
		}
		for(Flight f: flights){
			ftm.addRow(new Object[]{f.getDepartLocation(), f.getDepartTime().getTime(),
					f.getArriveLocation(), f.getArriveTime().getTime(), f.getFare()}, f);
		}
	}
	
	private void bookFlight(Flight f){
		try {
			List<Place> spaces = airline.chooseFlight(f);
			Place place = chooseSeat(spaces);
			// TODO choose tac
			TermsAndConditions tac = chooseTac(airline.getTerms());
			// TODO payment
			double price = airline.calculateFare(tac, f, place);
			if(payment(price)){
				Ticket ticket = airline.issueTicket(f, place, tac, customer);
				System.out.println(ticket.getTicketNo());
			} else {
				throw new CancelOperationException("Payment wasn't verified.");
			}
		} catch (CancelOperationException e) {
			JOptionPane.showMessageDialog(this,
				    e.getMessage(),
				    "Booking Canceled",
				    JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Place chooseSeat(List<Place> places){
		int num = places.size();
		String message = "";
		for(int i = 0; i < num; i++){
			if(i % 4 == 0){
				message += "\n";
			}
			Place p = places.get(i);
			message += (p.isVacant())? places.get(i).getPlaceNo() + " \t": "-- \t";
		}
		
		String seatNo = (JOptionPane.showInputDialog(this, message,
				"Choose terms and condition", JOptionPane.PLAIN_MESSAGE));
		int index = places.indexOf(new Seat(seatNo, 0, null));
		return places.get(index);
	}
	
	private TermsAndConditions chooseTac(List<TermsAndConditions> tacs){
		int num = tacs.size();
		Object[] options = new Object[num];
		String message = "";
		for(int i = 0; i < num; i++){
			options[i] = i;
			message += "Option" + i + "\n" + tacs.get(i).toString() + "\n";
		}
		int ch = (Integer)(JOptionPane.showInputDialog(this, message,
				"Choose terms and condition", JOptionPane.PLAIN_MESSAGE, null, options, "1"));
		return tacs.get(ch);
	}
	
	private boolean payment(double price){
		return JOptionPane.showConfirmDialog(this, "Do you pay €"+price+" for this ticket?",
				"Payment Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0;
	}
	
	private void showTicket(){
		List<Ticket> tickets = customer.getTick();
		String message = "";
		for(int i = 0; i < tickets.size(); i++){
			message += tickets.get(i).toString() + "\n";
		}
		JOptionPane.showMessageDialog(this, message, "Tickets", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void cancelTicket(){
		String input = JOptionPane.showInputDialog("Enter Ticket Number");
		int index = airline.getTickets().indexOf(new Ticket(input));
		if (index >= 0){
			Ticket ticket = airline.getTickets().get(index);
			if(ticket.isCancellable()){
				if(payment(ticket.getTac().getAdministrativeFee())){
					airline.cancelTicket(input);
				}
			}
		}
	}
}
