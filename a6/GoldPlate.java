package a6;

// Created a class that implements the Plate interface

public class GoldPlate extends PlateImpl {
	
	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, checkPrice(price), Plate.Color.GOLD);
	}
	
	public static double checkPrice (double price) {
		if (price < 5.0) {
			throw new IllegalArgumentException("Price must be greater than or equal to 5.0");
		}
		return price;
	}

}
