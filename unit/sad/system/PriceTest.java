package sad.system;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.management.relation.RoleList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import sad.system.plane.Place;
import sad.system.plane.Seat;

public class PriceTest {
	TermsAndConditions tac1 = new TermsAndConditions(true, 0.0, 1.0, 0.0);
	TermsAndConditions tac2 = new TermsAndConditions(true, 0.4, 0.4, 500);
	Airline airline = new Airline();

	@Test
	public void cancelFeeTest() {
		assertTrue(airline.calculateCancellationFee(tac1) == 0);
		assertTrue(airline.calculateCancellationFee(tac2) == 500);
	}
	
	@Test
	public void feeTest() {
		double price1 = airline.calculateFare(tac1,
				new Flight(null, null, null, null, null, 1200, null, null), new Seat(null, 50, null));
		assertTrue(1250*0.6 == price1);
	}

}
