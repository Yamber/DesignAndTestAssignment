package sad.system.plane;

import java.util.LinkedList;
import java.util.List;

public class PlaneBuilder {
	public static int planeNumber = 1;

	public static Plane SmallPlaneBuilder() {
		Plane plane = new Plane(planeNumber ++);
		List<Place> seats = new LinkedList<>();
		for(int i=1; i <= 3; i++){
			for(int j=1; j<=4; j++){
				Seat seat = new Seat(""+(i*10+j), 0.0, plane);
				seats.add(seat);
			}
		}
		plane.setPlaces(seats);
		return plane;
	}

}
