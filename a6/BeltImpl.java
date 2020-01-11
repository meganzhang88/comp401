package a6;

import java.util.ArrayList;
import java.util.Iterator;

import a6.Plate.Color;

// Create an implementation of the Belt interface called BeltImpl

public class BeltImpl implements Belt {
	
	// Create an ArrayList to represent the sushi belt
	ArrayList<Plate> belt = new ArrayList<Plate>();
	private int beltSize;
	
	public BeltImpl(int beltSize) {
		if (beltSize <= 0) {
			throw new IllegalArgumentException("belt size can not be zero or negative");
		}
		this.beltSize = beltSize;
		
		
		for (int i = 0; i < beltSize; i++) {
			belt.add(null);
		}
		
	}

	/* A getter for the size of the belt. */
	public int getSize() {
		return beltSize;
	}

	/* 	Returns the plate at the specified position on the belt 
	 *  or null if there is no Plate object there. */
	public Plate getPlateAtPosition(int position) {
		position = ((position % beltSize) + beltSize) % beltSize;
		
		if (belt.get(position) == null) {
			return null;
		} else {
			return belt.get(position);
		}
	}

	/* 	Sets a plate at the specified position on the belt. If the provided plate is null, 
	 *  throws an IllegalArgumentException. 
	 *  If there is already a plate at that position, throws a BeltPlateException.
	 */
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		position = ((position % beltSize) + beltSize) % beltSize;
		
		if (plate == null) {
			throw new IllegalArgumentException("the plate can not be null");
		}
		if (belt.get(position) != null) {
			throw new BeltPlateException(position, plate, belt);
		}
		belt.set(position,  plate);
	}

	/* 	Clears the specified position on the belt to null. */
	public void clearPlateAtPosition(int position) {
		position = ((position % beltSize) + beltSize) % beltSize;
		
		belt.set(position, null);
		
	}
	
	/* Removes the plate at the specified position off the belt and returns it. 
	 * If there is no plate at the specified position, throws a java.util.NoSuchElementException. 
	 * You should be able to write this method using getPlateAtPosition and clearPlateAtPosition described above.
	 */
	public Plate removePlateAtPosition(int position) {
		position = ((position % beltSize) + beltSize) % beltSize;
		
		if (belt.get(position) == null) {
			throw new java.util.NoSuchElementException();
		} else {
			clearPlateAtPosition(position);
			return getPlateAtPosition(position);
		}
	}
	
	/* This methods sets the provided plate at the specified position if possible.
	 * If not possible because the position is already occupied, attempts to set the plate at the next highest position.
	 * This continues until either the plate is successfully placed on the belt or all of the positions on the belt
	 * have been found to be occupied (remember as the value of position gets higher it will eventually wrap back
	 * around to the beginning of the belt). In the case that the belt is full and the plate can not be placed,
	 * throw a BeltFullException (described below). If successful, this method should return the position index where the plate ended up.
	 * This value should be in the range of 0 to size-1 where size is the size of the belt.
	 */
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		position = ((position % beltSize) + beltSize) % beltSize;
		if (position == beltSize - 1) {
			throw new BeltFullException(belt);
		} else {
			if (belt.get(position) == null) {
				belt.set(position,  plate);
				return position;
			} else {
				return setPlateNearestToPosition(plate, position + 1);
			}
		}
	}
	
	// Returns a BeltIterator object for this belt starting at position 0.
	public Iterator<Plate> iterator() {
		return iteratorFromPosition(0);
	}
	
	// Returns a BeltIterator object for this belt starting at the specified position.
	public Iterator<Plate> iteratorFromPosition(int position) {
		position = ((position % belt.size()) + belt.size()) % belt.size();
		return new BeltIterator(belt, position);
	}
	
	/*This method "rotates" the belt such that a Plate object set at position p before the rotate
	 * method, is now found at position p+1 after the rotate method.
	 */
	public void rotate() {
		ArrayList<Plate> clone = new ArrayList<Plate>();
		for (int i = 0; i < beltSize; i++) {
			clone.add(belt.get(i));
		}
		for (int i = 0; i < beltSize; i++) {
			belt.set(i, null);
		}
		for (int i = 1; i < beltSize - 1; i++) {
			belt.set(i, clone.get(i - 1));
		}
		belt.set(beltSize - 1, clone.get(0));
	}
	
	// Overloaded method
	public Iterator<Plate> iterator(Color colorFilter) {
		return new ColorFilteredBeltIterator(belt, 0, colorFilter);
	}

	// Overloaded method
	public Iterator<Plate> iterator(double maxPrice) {
		return new PriceThresholdBeltIterator(belt, 0, maxPrice);
	}

	// Overloaded method
	public Iterator<Plate> iteratorFromPosition(int position, Color colorFilter) {
		position = ((position % belt.size()) + belt.size()) % belt.size();
		return new ColorFilteredBeltIterator(belt, position, colorFilter);
	}

	// Overloaded method
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice) {
		position = ((position % belt.size()) + belt.size()) % belt.size();
		return new PriceThresholdBeltIterator(belt, position, maxPrice);
	}

}
