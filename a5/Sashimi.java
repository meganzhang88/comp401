package a5;

public class Sashimi implements Sushi {
	
	public enum SashimiType { TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP };
	
	private String name;
	private IngredientPortionImpl[] ingredientPortions = new IngredientPortionImpl[1];
			
	public Sashimi(SashimiType type) {
		if (type.equals(SashimiType.TUNA)) {
			this.name = "tuna sashimi";
			ingredientPortions[0] = new TunaPortion(0.75);
		}
		if (type.equals(SashimiType.YELLOWTAIL)) {
			this.name = "yellowtail sashimi";
			ingredientPortions[0] = new YellowtailPortion(0.75);
		}
		if (type.equals(SashimiType.EEL)) {
			this.name = "eel sashimi";
			ingredientPortions[0] = new EelPortion(0.75);
		}
		if (type.equals(SashimiType.CRAB)) {
			this.name = "crab sashimi";
			ingredientPortions[0] = new CrabPortion(0.75);
		}
		if (type.equals(SashimiType.SHRIMP)) {
			this.name = "shrimp sashimi";
			ingredientPortions[0] = new ShrimpPortion(0.75);
		}
	}

	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ingredientPortions;
	}

	public int getCalories() {
		return (int) Math.round(ingredientPortions[0].getCalories());
	}

	public double getCost() {
		return Math.round((ingredientPortions[0].getCost()) * 100.0) / 100.0;
	}
	
	public boolean getHasRice() {
		return false;
	}

	public boolean getHasShellfish() {
		return ingredientPortions[0].getIsShellfish();
	}

	public boolean getIsVegetarian() {
		return false;
	}
}