package system.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import system.Airline;
import system.AirlineBuilder;
import system.customer.Customer;
import system.customer.PersonalCustomer;

import com.toedter.calendar.JDateChooser;

public class CustomerGui extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg;
	private JDateChooser jdcDeparting;
	private JDateChooser jdcReturning;
	private JSpinner sprDepart;
	private JSpinner sprReturn;
	private JSpinner sprClass;
	private JSpinner sprNumTicket;
	private JTextField textField;
	private Customer customer;
	private Airline airline;

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
				sprReturn.setEnabled(true);
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
				sprReturn.setEnabled(false);
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
		
		sprReturn = new JSpinner();
		sprReturn.setModel(new SpinnerListModel(new String[] {"DUB", "LON", "KIX", "WAT"}));
		sprReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprReturn.setBounds(303, 28, 100, 20);
		contentPane.add(sprReturn);
		
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
		
		JButton btnBook = new JButton("Book Now");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO search flight from Airline instance
			}
		});
		btnBook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnBook.setBounds(10, 139, 584, 41);
		contentPane.add(btnBook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 584, 218);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 605, 21);
		contentPane.add(menuBar);
	}
}