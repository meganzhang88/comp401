package a6;

public class AvocadoPortion extends IngredientPortionImpl {
	
	public AvocadoPortion (double amount) {
		super(new Avocado(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new AvocadoPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new AvocadoPortion(this.getAmount() + other.getAmount());
	}
	
}
