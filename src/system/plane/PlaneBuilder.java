package system.plane;

import java.util.LinkedList;
import java.util.List;

public class PlaneBuilder {
	public static int planeNumber = 1;

	public static Plane SmallPlaneBuilder() {
		Plane plane = new Plane(planeNumber ++);
		List<Place> seats = new LinkedList<>();
		for(int i=1; i <= 3; i++){
			for(int j=1; i<=4; i++){
				Seat seat = new Seat(""+(i*10+j), plane);
				seats.add(seat);
			}
		}
		plane.setPlaces(seats);
		return plane;
	}

}
