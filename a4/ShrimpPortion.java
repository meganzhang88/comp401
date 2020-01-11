package a4;

public class ShrimpPortion extends IngredientPortionImpl {
	
	public ShrimpPortion (double amount) {
		super(new Shrimp(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new ShrimpPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new ShrimpPortion(this.getAmount() + other.getAmount());
	}

}
