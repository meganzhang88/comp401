package a6;

import java.util.ArrayList;
import java.util.Iterator;

//Create a new implementation of Iterator that supports the ability to iterate only over plates on a belt
//that match a maximum price

public class ColorFilteredBeltIterator implements Iterator {
	private ArrayList<Plate> belt;
	private int startPosition;
	private Plate.Color colorFilter;
	private boolean nextCalled;
	
	public ColorFilteredBeltIterator(ArrayList<Plate> belt, int startPosition, Plate.Color colorFilter) {
		this.belt = belt;
		
		startPosition = ((startPosition % belt.size()) + belt.size()) % belt.size();
		this.startPosition = startPosition;

		
		this.colorFilter = colorFilter;
		this.nextCalled = false;
	
	}

	// Indicates that there is a next plate object to be iterated.
	// This method should only return false if the belt is completely empty.
	public boolean hasNext() {
		for (int i = 0; i < belt.size(); i++) {
			startPosition = ((startPosition % belt.size()) + belt.size()) % belt.size();
			if (belt.get(startPosition) != null && belt.get(startPosition).getColor() == colorFilter) {
				nextCalled = true;
				return true;
			}
			startPosition++;
		}
		return false;
	}

	// Retrieve the next plate from the belt. Note that this should not remove the plate from the belt.
	// If next is called on an empty belt, should throw a java.util.NoSuchElementException.
	public Plate next() {
		startPosition = ((startPosition % belt.size()) + belt.size()) % belt.size();
		Plate answer = null;
		if (!hasNext()) {
			throw new java.util.NoSuchElementException();
		} else {
			for (int i = 0; i < belt.size(); i++) {
				if (belt.get(startPosition) != null && belt.get(startPosition).getColor() == colorFilter) {
					answer = belt.get(startPosition);
					startPosition++;
					nextCalled = true;
					return answer;
				}
			}
		}
		return answer;
	}
	
	public void remove() {
		if (!nextCalled) {
			throw new IllegalStateException();
		} else {
			belt.set(startPosition - 1, null);
			nextCalled = false;
		}
	}
}
