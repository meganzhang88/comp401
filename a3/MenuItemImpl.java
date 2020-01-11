package a3;

public class MenuItemImpl implements MenuItem {
	
	private String name;
	private IngredientPortion[] ingredients;
	
	public MenuItemImpl(String name, IngredientPortion[] ingredients) {
				
		if (name == null) {
			throw new RuntimeException("Name is null");
		}
		if (ingredients == null) {
			throw new RuntimeException("Ingredients is null");
		}
		if (ingredients.length <= 0) {
			throw new RuntimeException("Ingredients length is less than 0");
		}
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] == null) {
				throw new RuntimeException("Ingredients contains a null element");
			}
		}
		this.name = name;
		this.ingredients = ingredients.clone();
	}

	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}

	public int getCalories() {
		int sum = 0;
		IngredientPortion[] clone = ingredients.clone();
		for (int i = 0; i < clone.length; i++) {
			sum += clone[i].getCalories();
		}
		return sum;
	}

	public double getCost() {
		double cost = 0;
		for (int i = 0; i < ingredients.length; i++) {
			cost = cost + ingredients[i].getCost();
		}
		return (double) Math.round(cost * 100) / 100;

	}

	public boolean getIsVegetarian() {
		IngredientPortion[] clone = ingredients.clone();
		for (int i = 0; i < ingredients.length; i++) {
			if (clone[i].getIngredient().getIsVegetarian() == false) {
				return false;
			}
		}
		return true;
	}	
}
