package sad.system.plane;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlaneTest {
	private Plane plane;
	
	@Before
	public void setUp(){
		plane = PlaneBuilder.SmallPlaneBuilder();
	}
	
	@Test
	public void vacantTest(){
		Place place13 = plane.getSpace("13");
		Place place24 = plane.getSpace("24");
		place24.setVacant(false);
		assertTrue(place13.isVacant());
		assertTrue(!place24.isVacant());
	}

	@Test
	public void checkInTest() {
		Place place13 = plane.getSpace("13");
		Place place24 = plane.getSpace("24");
		place13.checkIn();
		assertTrue(place13.isCheckIn());
		assertTrue(!place24.isCheckIn());
	}

	@Test
	public void cancelTest(){
		Place place13 = plane.getSpace("13");
		Place place24 = plane.getSpace("24");
		place13.checkIn();
		place24.checkIn();
		place13.cancelCheckIn();
		assertTrue(!place13.isCheckIn());
		assertTrue(place24.isCheckIn());
	}

}
