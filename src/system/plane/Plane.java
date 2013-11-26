package system.plane;

import java.util.LinkedList;

public class Plane {
	
	private int planeNo;
	private String destination;
	private LinkedList<Space> spaces;
	
	public Plane(int planeNo, String destination){
		
		this.setPlaneNo(planeNo);
		this.setDestination(destination);
		setSpaces(new LinkedList<Space>());
	}

	public int getPlaneNo() {
		return planeNo;
	}

	public void setPlaneNo(int planeNo) {
		this.planeNo = planeNo;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LinkedList<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(LinkedList<Space> spaces) {
		this.spaces = spaces;
	}

}
