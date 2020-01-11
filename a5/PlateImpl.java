package a5;

// Created a class that implements the Plate interface

public abstract class PlateImpl implements Plate {
	
	private Sushi contents;
	private Plate.Color color;
	private double price;
	
	public PlateImpl(Sushi contents, double price, Plate.Color color) throws PlatePriceException {
		if ((contents != null) && (contents.getCost() > price)) {
			throw new PlatePriceException(price);
		}
		this.color = color;
		this.price = price;
		this.contents = contents;
	}
	
	// Returns the contents of the plate. If the plate is empty, returns null.
	
	public Sushi getContents() {
		return contents;
	}

	// If the plate is already empty, this method does nothing and returns null.
	// If not empty, the plate is made empty and the prior contents of the plate is returned.
	
	public Sushi removeContents() {
		Sushi priorContents = contents;
		contents = null;
		return priorContents;
	}
	
	// This method sets the contents of the plate to be the Sushi object passed in as parameter s,
	// replacing any prior contents the plate may have had, if any. If s is null, this method should
	// throw an IllegalArgumentException. If the price of the plate is less than or equal to the
	// cost of the Sushi being placed on it (i.e., there is no profit), then this method should throw a PlatePriceException.
	// If either of these exceptions occurs, the plate should remain unchanged.

	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("s must not be null");
		}
		if (price <= s.getCost()) {
			throw new PlatePriceException(price);
		}
		contents = s;
	}
	
	// Returns true if the plate has sushi on it, false if not.
	
	public boolean hasContents() {
		return (contents != null);
	}
	
	// Returns the price associated with the plate.

	public double getPrice() {
		return price;
	}
	
	// Returns the color associated with the plate as represented by one of the 
	// Plate.Color enumeration symbols.

	public Color getColor() {
		return color;
	}
	
	// If the plate is empty, returns 0.0. Otherwise, returns the difference between
	// the price of the plate and the cost of the sushi on it.
	
	public double getProfit() {
		if (contents == null) {
			return 0.0;
		} else {
			return price - contents.getCost();
		}
	}
	
}