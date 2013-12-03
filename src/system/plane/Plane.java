package system.plane;

import java.util.LinkedList;

public class Plane {
	
	private int planeNo;
	private LinkedList<Space> spaces;
	
	public Plane(int planeNo){
		this.setPlaneNo(planeNo);
		spaces = new LinkedList<Space>();
	}

	public int getPlaneNo() {
		return planeNo;
	}

	public void setPlaneNo(int planeNo) {
		this.planeNo = planeNo;
	}

	public LinkedList<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(LinkedList<Space> spaces) {
		this.spaces = spaces;
	}

}
