package a5;

public class EelPortion extends IngredientPortionImpl {
	
	public EelPortion (double amount) {
		super(new Eel(), amount);
		if (amount <= 0) {
			throw new RuntimeException("Amount is not greater than 0");
		}
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		IngredientPortion currentObject = new EelPortion(this.getAmount());
		
		if (other == null) {
			return currentObject;
		} 
		if (!currentObject.getIngredient().equals(other.getIngredient())) {
			throw new RuntimeException("Other is a portion of a different ingredient");
		}
		return new EelPortion(this.getAmount() + other.getAmount());
	}

}
