package a3;

import java.util.Arrays;
import java.util.Scanner;

public class A3Jedi {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int numberOfIngredients = scan.nextInt();
		IngredientImpl[] ingredientsArray = new IngredientImpl[numberOfIngredients];
		
		for (int i = 0; i < numberOfIngredients; i++) {
			
			String ingredientName = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			
			IngredientImpl newIngredient = new IngredientImpl(ingredientName, pricePerOunce, caloriesPerOunce, isVegetarian);
			ingredientsArray[i] = newIngredient;
		}
		int numberOfMenuItems = scan.nextInt();
		MenuItemImpl[] menuItemsArray = new MenuItemImpl[numberOfMenuItems];
		
		for (int j = 0; j < numberOfMenuItems; j++) {
			
			String menuItemName = scan.next();
			int ingredientsRequired = scan.nextInt();
			IngredientPortion[] ingredientPortionsArray = new IngredientPortion[numberOfIngredients];
			
			for (int k = 0; k < ingredientsRequired; k++) {
				
				String singleIngredientName = scan.next();
				double singleIngredientPortion = scan.nextDouble();
				
				for (int l = 0; l < numberOfIngredients; l++) {
					
					if (singleIngredientName.equals(ingredientsArray[l].getName())) {
						IngredientPortionImpl newIngredientPortion = new IngredientPortionImpl(ingredientsArray[l], singleIngredientPortion);
						ingredientPortionsArray[l] = newIngredientPortion;
					} else if (ingredientPortionsArray[l] == null){
						IngredientPortionImpl emptyIngredientPortion = new IngredientPortionImpl(ingredientsArray[l], 0);
						ingredientPortionsArray[l] = emptyIngredientPortion;
					}
				}
			}
			menuItemsArray[j] = new MenuItemImpl(menuItemName, ingredientPortionsArray);
		}
		
		double[] finalAmounts = new double[numberOfIngredients];
		
		String itemOrder = scan.next();
		while (!"EndOrder".equals(itemOrder)) {
			
			for (int m = 0; m < menuItemsArray.length; m++) {
				if (itemOrder.equals(menuItemsArray[m].getName())) {
					for (int o = 0; o < menuItemsArray[m].getIngredients().length; o++) {
						for (int p = 0; p < numberOfIngredients; p++) {
							if (menuItemsArray[m].getIngredients()[o].getName().equals(ingredientsArray[p].getName())) {
								finalAmounts[p] += menuItemsArray[m].getIngredients()[o].getAmount();
							}
						}
					}
					
				}
			}
			itemOrder = scan.next();
		}
		
		System.out.println("The order will require: ");
		
		for (int n = 0; n < numberOfIngredients; n++) {
			System.out.println(String.format("%.2f", finalAmounts[n]) + " ounces of " + ingredientsArray[n].getName());
		}
	}
}
