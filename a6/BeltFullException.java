package a6;

import java.util.ArrayList;

// Create a BeltFullException class to support the setPlateNearestToPosition method.
// This class should be a checked exception.

public class BeltFullException extends Exception {
	private ArrayList<Plate> belt;
	
	public BeltFullException(ArrayList<Plate> belt) {
		this.belt = belt;
	}
	
	public Belt getBelt() {
		return (Belt) belt;
	}

}
