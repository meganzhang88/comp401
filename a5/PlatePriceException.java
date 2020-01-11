package a5;

// Created new checked exception class called PlatePriceException
// The message associated with this exception should be "Illegal plate price"

public class PlatePriceException extends Exception {
	
	private double platePrice;
	
	public PlatePriceException(double price) {
		super("Illegal plate price");
		platePrice = price;
	}
	
	public double getPlatePriceException() {
		return platePrice;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " (" + platePrice + ")";
	}
	
}
