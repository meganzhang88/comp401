package a7;

import comp401sushi.Plate;

// A PlateCounter object keeps track of the plates on a belt by color. A PlateCounter should
// keep a running count of plates of each color as plates are added / removed from the belt

public class PlateCounter implements BeltObserver {
	private Belt b;
	private int redPlateCount;
	private int greenPlateCount;
	private int bluePlateCount;
	private int goldPlateCount;
	
/*The PlateCounter constructor should register the object as a belt observer of Belt b. If the parameter b is null,
 * the constructor should throw an IllegalArgumentException. Upon construction, a PlateCounter should initialize its counts
 * of red, green, blue, and gold plates according to the current contents of the belt. From that point on, it should
 * modify its counts by processing PlateEvent objects as delivered to its handlePlateEvent method as appropriate.
 */
	
	public PlateCounter(Belt b) {
		
		if (b == null) {
			throw new IllegalArgumentException("Belt can not be null");
		} else {
			b.addBeltObserver(this);
		} 
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue;
			}
			if ( b.getPlateAtPosition(i).getColor() == Plate.Color.RED) {
				redPlateCount++;
			}
			if ( b.getPlateAtPosition(i).getColor() == Plate.Color.GREEN) {
				greenPlateCount++;
			}
			if ( b.getPlateAtPosition(i).getColor() == Plate.Color.BLUE) {
				bluePlateCount++;
			}
			if ( b.getPlateAtPosition(i).getColor() == Plate.Color.GOLD) {
				goldPlateCount++;
			}
		}
		
	}

	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == PlateEvent.EventType.PLATE_REMOVED) {
			if (e.getPlate().getColor() == Plate.Color.RED) {
				redPlateCount--;
			}
			if (e.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlateCount--;
			}
			if (e.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlateCount--;
			}
			if (e.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlateCount--;
			}
		} else {
			if (e.getPlate().getColor() == Plate.Color.RED) {
				redPlateCount++;
			}
			if (e.getPlate().getColor() == Plate.Color.GREEN) {
				greenPlateCount++;
			}
			if (e.getPlate().getColor() == Plate.Color.BLUE) {
				bluePlateCount++;
			}
			if (e.getPlate().getColor() == Plate.Color.GOLD) {
				goldPlateCount++;
			}
		}
	}

// PlateCounter should provide the following getters for retrieving the current count of each plate color:
	public int getRedPlateCount() {
		return redPlateCount;
	}
	
	public int getBluePlateCount() {
		return bluePlateCount;
	}
	
	public int getGreenPlateCount() {
		return greenPlateCount;
	}
	
	public int getGoldPlateCount() {
		return goldPlateCount;
	}

}
