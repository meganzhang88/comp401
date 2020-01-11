package a6;

public class TunaPortion extends IngredientPortionImpl {
	
	public TunaPortion (double amount) {
		super(new Tuna(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new TunaPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new TunaPortion(this.getAmount() + other.getAmount());
	}
}
