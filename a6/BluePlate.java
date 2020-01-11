package a6;

// Created a class that implements the Plate interface

public class BluePlate extends PlateImpl {
	
	public BluePlate(Sushi contents) throws PlatePriceException {
		super(contents, 4.0, Plate.Color.BLUE);
	}

}
