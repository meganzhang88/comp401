package a5;

// Created a class that implements the Plate interface

public class RedPlate extends PlateImpl {
	
	public RedPlate(Sushi contents) throws PlatePriceException {
		super(contents, 1.0, Plate.Color.RED);
	}
}