package a6;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private double caloriesPerDollar;
	private int caloriesPerOunce;
	private double pricePerOunce;
	private boolean equals;
	private boolean isVegetarian;
	private boolean isRice;
	private boolean isShellfish;
	
	public IngredientImpl(String name, int caloriesPerOunce, double pricePerOunce, boolean isVegetarian, boolean isRice, boolean isShellfish) {
		this.name = name;
		this.caloriesPerOunce = caloriesPerOunce;
		this.pricePerOunce = pricePerOunce;
		this.isVegetarian = isVegetarian;
		this.isRice = isRice;
		this.isShellfish = isShellfish;
	}

	public String getName() {
		return name;
	}

	public double getCaloriesPerDollar() {
		double ouncesPerDollar = 1 / pricePerOunce;
		return ouncesPerDollar * caloriesPerOunce;
	}

	public int getCaloriesPerOunce() {
		return caloriesPerOunce;
	}

	public double getPricePerOunce() {
		return pricePerOunce;
	}

	public boolean equals(Ingredient other) {
		if (this.name.equals(other.getName()) && this.caloriesPerOunce == other.getCaloriesPerOunce() && this.isVegetarian == other.getIsVegetarian() && this.isRice == other.getIsRice() && this.isShellfish == other.getIsShellfish()) {
			return true;
		}
		return false;
	}

	public boolean getIsVegetarian() {
		return isVegetarian;
	}

	public boolean getIsRice() {
		return isRice;
	}

	public boolean getIsShellfish() {
		return isShellfish;
	}

}
