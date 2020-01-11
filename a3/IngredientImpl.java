package a3;

public class IngredientImpl implements Ingredient {
	
	private String name;
	private boolean is_vegetarian;
	private double price;
	private int calories;
	private double caloriesPerDollar;
	
	public IngredientImpl(String name, double price, int calories, boolean is_vegetarian) {
		if (name == null) {
			throw new RuntimeException("name is null");
		}
		if (price < 0) {
			throw new RuntimeException("price is negative");
		}
		if (calories < 0) {
			throw new RuntimeException("calories is negative");
		}
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.is_vegetarian = is_vegetarian;
		
	}
	public String getName() {
		return name;
	}

	public boolean getIsVegetarian() {
		return is_vegetarian;
	}

	public double getPricePerOunce() {
		return price;
	}

	public int getCaloriesPerOunce() {
		return calories;
	}

	public double getCaloriesPerDollar() {
		return calories / price;
	}
	
}
