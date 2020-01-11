package a5;

import java.util.ArrayList;

public class Roll implements Sushi {
	
	ArrayList<IngredientPortion> ingredientList = new ArrayList<IngredientPortion>();
	
	private String name;
	private IngredientPortion[] roll_ingredients;
	
	public Roll(String name, IngredientPortion[] roll_ingredients) {
		if (roll_ingredients == null) {
			throw new RuntimeException("roll_ingredients array is null");
		}
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("roll_ingredients contains a null element");
			}
		}
		this.name = name;
		
		for (int i = 0; i < roll_ingredients.length; i++) {
			ingredientList.add(roll_ingredients[i]);
		}
		
		for (int i = 0; i < ingredientList.size() ; i++) {
			IngredientPortion currentIngredient = ingredientList.get(i);
			
			for (int j = i + 1; j < ingredientList.size(); j++) {
				if (currentIngredient.getIngredient().equals(ingredientList.get(j).getIngredient())) {
					ingredientList.set(i, currentIngredient.combine(ingredientList.get(j)));
					ingredientList.remove(j);
				}
			}
		}
		double seaweedAmount = 0;
		SeaweedPortion seaweedIngredient = new SeaweedPortion(0.12);
		
		for (int i = 0; i < ingredientList.size(); i++) {
			if (ingredientList.get(i).getIngredient().equals(seaweedIngredient.getIngredient())) {
				seaweedAmount += ingredientList.get(i).getAmount();
			}
		}
		
		double seaweedNeeded = 0;
		if (seaweedAmount < 0.1) {
			seaweedNeeded = 0.12 - seaweedAmount;
			SeaweedPortion seaweedPortionAdded = new SeaweedPortion(seaweedNeeded);
			ingredientList.add(seaweedPortionAdded);
		}
		
		
		IngredientPortion[] finalRollIngredients = new IngredientPortion[ingredientList.size()];
		ingredientList.toArray(finalRollIngredients);
		
		this.roll_ingredients = finalRollIngredients.clone();
				
	}
	
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return roll_ingredients;
	}

	public int getCalories() {
		int calories = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			calories += roll_ingredients[i].getCalories();
		}
		return calories;
	}

	public double getCost() {
		double cost = 0;
		for (int i = 0; i < roll_ingredients.length; i++) {
			cost += roll_ingredients[i].getCost();
		}
		double roundOff = Math.round(cost * 100.0) / 100.0;
		return roundOff;
	}

	public boolean getHasRice() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getIsRice()) {
				return true;
			}
		}
		return false;
	}

	public boolean getHasShellfish() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getIsShellfish()) {
				return true;
			}
		}
		return false;
	}

	public boolean getIsVegetarian() {
		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i].getIsVegetarian()) {
				return true;
			}
		}
		return false;
	}

}