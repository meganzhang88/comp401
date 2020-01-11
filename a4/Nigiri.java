package a4;

public class Nigiri implements Sushi {
	
	public enum NigiriType { TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP };
	
	private String name;
	private IngredientPortion[] ingredientPortions = new IngredientPortion[2];
	RicePortion rice = new RicePortion(0.5);
	
	public Nigiri(NigiriType type) {
		if (type.equals(NigiriType.TUNA)) {
			this.name = "tuna nigiri";
			ingredientPortions[0] = new TunaPortion(0.75);
			ingredientPortions[1] = rice;
		}
		if (type.equals(NigiriType.YELLOWTAIL)) {
			this.name = "yellowtail nigiri";
			ingredientPortions[0] = new YellowtailPortion(0.75);
			ingredientPortions[1] = new RicePortion(.5);
		}
		if (type.equals(NigiriType.EEL)) {
			this.name = "eel nigiri";
			ingredientPortions[0] = new EelPortion(0.75);
			ingredientPortions[1] = new RicePortion(.5);
		}
		if (type.equals(NigiriType.CRAB)) {
			this.name = "crab nigiri";
			ingredientPortions[0] = new CrabPortion(0.75);
			ingredientPortions[1] = new RicePortion(.5);
		}
		if (type.equals(NigiriType.SHRIMP)) {
			this.name = "shrimp nigiri";
			ingredientPortions[0] = new ShrimpPortion(0.75);
			ingredientPortions[1] = new RicePortion(.5);
		}
	}
	
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ingredientPortions;
	}

	public int getCalories() {
		return (int) Math.round((ingredientPortions[0].getCalories() + ingredientPortions[1].getCalories()));
	}

	public double getCost() {
		return Math.round((ingredientPortions[0].getCost() + ingredientPortions[1].getCost()) * 100.0) / 100.0;
	}

	public boolean getHasRice() {
		return true;
	}

	public boolean getHasShellfish() {
		if (ingredientPortions[0].getIsShellfish() && ingredientPortions[1].getIsShellfish()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getIsVegetarian() {
		return false;
	}
}