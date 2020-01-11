package a5;

public class CrabPortion extends IngredientPortionImpl {
	
	public CrabPortion (double amount) {
		super(new Crab(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new CrabPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new CrabPortion(this.getAmount() + other.getAmount());
	}

}
