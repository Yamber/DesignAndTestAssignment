package system.plane;

import java.util.LinkedList;
import java.util.List;

public class Plane {
	
	private int planeNo;
	private List<Place> places;
	
	public Plane(int planeNo){
		this.setPlaneNo(planeNo);
		places = new LinkedList<>();
	}

	public int getPlaneNo() {
		return planeNo;
	}

	public void setPlaneNo(int planeNo) {
		this.planeNo = planeNo;
	}
	
	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	public void addPlace(Place place){
		places.add(place);
	}
	
	public Place getSpace(int i){
		return places.get(i);
	}

}
