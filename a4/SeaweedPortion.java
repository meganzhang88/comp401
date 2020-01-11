package a4;

public class SeaweedPortion extends IngredientPortionImpl {
	
	public SeaweedPortion (double amount) {
		super(new Seaweed(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new SeaweedPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new SeaweedPortion(this.getAmount() + other.getAmount());
	}

}
