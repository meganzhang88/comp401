package a6;

public class IngredientPortionImpl implements IngredientPortion {
	
	private Ingredient ingredient;
	private double amount;

	public IngredientPortionImpl(Ingredient ingredient, double amount) {
		this.ingredient = ingredient;
		this.amount = amount;
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}

	public String getName() {
		return ingredient.getName();
	}

	public double getAmount() {
		return amount;
	}

	public double getCalories() {
		return this.ingredient.getCaloriesPerOunce() * amount;
	}

	public double getCost() {
		return this.ingredient.getPricePerOunce() * amount;
	}

	public boolean getIsVegetarian() {
		return this.ingredient.getIsVegetarian();
	}

	public boolean getIsRice() {
		return this.ingredient.getIsRice();
	}

	public boolean getIsShellfish() {
		return this.ingredient.getIsShellfish();
	}

	public IngredientPortion combine(IngredientPortion other) {
		return null;
	}
}
