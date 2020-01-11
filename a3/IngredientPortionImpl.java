package a3;

public class IngredientPortionImpl implements IngredientPortion {

	private Ingredient ing;
	private double amount;
	
	public IngredientPortionImpl(Ingredient ing, double amount) {
		if (ing == null) {
			throw new RuntimeException("Ingredient is equal to null");
		}
		if (amount < 0) {
			throw new RuntimeException("Amount is negative");
		}
		this.ing = ing;
		this.amount = amount;
	}

	public Ingredient getIngredient() {
		return ing;
	}	
	
	public double getAmount() {
		return amount;
	}
	
	public String getName() {
		return this.ing.getName();
	}
	
	public boolean getIsVegetarian() {
		return this.ing.getIsVegetarian();
	}

	public double getCalories() {
		return this.ing.getCaloriesPerOunce() * amount;
	}

	public double getCost() {
		return this.ing.getPricePerOunce() * amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		
		IngredientPortion currentObject = new IngredientPortionImpl(this.ing, this.amount);
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new IngredientPortionImpl(this.ing, this.amount + other.getAmount());
	}

}
