package sad.system.gui;

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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

public class FlightDetailChoosePane extends JPanel {
	private ButtonGroup bg;
	private JDateChooser jdcDeparting;
	private JDateChooser jdcReturning;
	private JSpinner sprDepart;
	private JSpinner sprReturn;
	private JSpinner sprClass;
	private JSpinner sprNumTicket;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FlightDetailChoosePane() {
		setLayout(null);
		
		JLabel lblDeparting = new JLabel("Departing");
		lblDeparting.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblDeparting.setBounds(6, 37, 120, 30);
		add(lblDeparting);
		
		jdcDeparting = new JDateChooser(new Date());
		jdcDeparting.setBounds(136, 43, 140, 24);
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
		add(jdcDeparting);
		
		JLabel lblReturning = new JLabel("Returning");
		lblReturning.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblReturning.setBounds(320, 37, 120, 30);
		add(lblReturning);
		
		jdcReturning = new JDateChooser(new Date(new Date().getTime() + 86400000));
		jdcReturning.setBounds(450, 43, 140, 24);
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
		add(jdcReturning);

		bg = new ButtonGroup();
		
		JRadioButton rdbtnReturn = new JRadioButton("Return");
		rdbtnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sprReturn.setEnabled(true);
				jdcReturning.setEnabled(true);
			}
		});
		rdbtnReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		rdbtnReturn.setBounds(6, 7, 65, 23);
		rdbtnReturn.setSelected(true);
		bg.add(rdbtnReturn);
		add(rdbtnReturn);
		
		JRadioButton rdbtnOneWay = new JRadioButton("One Way");
		rdbtnOneWay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sprReturn.setEnabled(false);
				jdcReturning.setEnabled(false);
			}
		});
		rdbtnOneWay.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		rdbtnOneWay.setBounds(73, 7, 80, 23);
		bg.add(rdbtnOneWay);
		add(rdbtnOneWay);
		
		sprDepart = new JSpinner();
		sprDepart.setModel(new SpinnerListModel(new String[] {"DUB", "LON", "KIX", "WAT"}));
		sprDepart.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprDepart.setBounds(159, 8, 100, 20);
		add(sprDepart);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblTo.setBounds(269, 12, 20, 14);
		add(lblTo);
		
		sprReturn = new JSpinner();
		sprReturn.setModel(new SpinnerListModel(new String[] {"DUB", "LON", "KIX", "WAT"}));
		sprReturn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprReturn.setBounds(299, 8, 100, 20);
		add(sprReturn);
		
		JLabel lblClass = new JLabel("Class");
		lblClass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblClass.setBounds(6, 78, 120, 30);
		add(lblClass);
		
		sprClass = new JSpinner();
		sprClass.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprClass.setModel(new SpinnerListModel(new String[] {"Economy", "Business"}));
		sprClass.setBounds(136, 87, 140, 24);
		add(sprClass);
		
		JLabel lblNumberOfTicket = new JLabel("Number of Ticket");
		lblNumberOfTicket.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		lblNumberOfTicket.setBounds(320, 78, 200, 30);
		add(lblNumberOfTicket);
		
		sprNumTicket = new JSpinner();
		sprNumTicket.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		sprNumTicket.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		sprNumTicket.setBounds(530, 86, 60, 24);
		add(sprNumTicket);
		
		JButton btnBook = new JButton("Book Now");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO search flight from Airline instance
			}
		});
		btnBook.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		btnBook.setBounds(6, 119, 584, 41);
		add(btnBook);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 171, 584, 218);
		add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setBounds(100, 100, 600, 400);
					frame.setContentPane(new FlightDetailChoosePane());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
