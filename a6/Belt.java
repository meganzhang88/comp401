package a6;

import java.util.Iterator;

/**
 * The Belt interface represents the belt in a sushi restaurant upon which 
 * Plate objects are placed. 
 * 
 * Positions on the belt are nominally numbered from 0 to size-1 but any integer
 * can be interpreted as a valid position as follows:
 * 
 * If a position value greater than size-1 is used, it should be understood as
 * having wrapped around back to the beginning of the belt. In other words, using
 * the value size as a position is the same as using the value 0, size+1 is the
 * same as the value 1, and so on. 
 * 
 * Similarly, negative values for positions are understood as having wrapped around
 * to the end of the belt. So the value -1 as a position is the same as using size-1, -2
 * the same as size-2, etc. 
 * 
 * 
 */

public interface Belt extends Iterable{

	/* A getter for the size of the belt. */
	public int getSize();
	
	
	/* 	Returns the plate at the specified position on the belt 
	 *  or null if there is no Plate object there. */
	public Plate getPlateAtPosition(int position);

	
	/* 	Sets a plate at the specified position on the belt. If the provided plate is null, 
	 *  throws an IllegalArgumentException. 
	 *  If there is already a plate at that position, throws a BeltPlateException.
	 */
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException;
		
	
	/* 	Clears the specified position on the belt to null. */
	 public void clearPlateAtPosition(int position);

	 
	/* Removes the plate at the specified position off the belt and returns it. 
	 * If there is no plate at the specified position, throws a java.util.NoSuchElementException. 
	 * You should be able to write this method using getPlateAtPosition and clearPlateAtPosition described above.
	 */
	public Plate removePlateAtPosition(int position);
	
	/* This methods sets the provided plate at the specified position if possible.
	 * If not possible because the position is already occupied, attempts to set the plate at the next highest position.
	 * This continues until either the plate is successfully placed on the belt or all of the positions on the belt
	 * have been found to be occupied (remember as the value of position gets higher it will eventually wrap back
	 * around to the beginning of the belt). In the case that the belt is full and the plate can not be placed,
	 * throw a BeltFullException (described below). If successful, this method should return the position index where the plate ended up.
	 * This value should be in the range of 0 to size-1 where size is the size of the belt.
	 */
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException;
	
	// Returns a BeltIterator object for this belt starting at position 0.
	public Iterator<Plate> iterator();
	
	// Returns a BeltIterator object for this belt starting at the specified position.
	public Iterator<Plate> iteratorFromPosition(int position);
	
	/*This method "rotates" the belt such that a Plate object set at position p before the rotate
	 * method, is now found at position p+1 after the rotate method.
	 */
	public void rotate();
	
	public Iterator<Plate> iterator(Plate.Color colorFilter);
	public Iterator<Plate> iterator(double maxPrice);
	public Iterator<Plate> iteratorFromPosition(int position, Plate.Color colorFilter);
	public Iterator<Plate> iteratorFromPosition(int position, double maxPrice);
}
