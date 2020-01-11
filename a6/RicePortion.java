package a6;

public class RicePortion extends IngredientPortionImpl {
	
	public RicePortion (double amount) {
		super(new Rice(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new RicePortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new RicePortion(this.getAmount() + other.getAmount());
	}

}
