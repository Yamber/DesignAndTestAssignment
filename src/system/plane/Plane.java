package system.plane;

import java.util.LinkedList;
import java.util.List;

public class Plane {
	
	private int planeNo;
	private List<Space> spaces;
	
	public Plane(int planeNo){
		this.setPlaneNo(planeNo);
		spaces = new LinkedList<>();
	}

	public int getPlaneNo() {
		return planeNo;
	}

	public void setPlaneNo(int planeNo) {
		this.planeNo = planeNo;
	}

	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}
	
	public void addSpace(Space space){
		spaces.add(space);
	}
	
	public Space getSpace(int i){
		return spaces.get(i);
	}

}
