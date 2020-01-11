package a2;

import java.util.Arrays;
import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numberOfIngredients = scan.nextInt();
		String[] ingredientsArray = new String[numberOfIngredients];
		double[] finalAmountsArray = new double[numberOfIngredients];
		
		for (int i = 0; i < numberOfIngredients; i++) {
			String ingredient = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			
			ingredientsArray[i] = ingredient;
		}
		
		int numberOfRecipes = scan.nextInt();
		String[] menuItemsArray = new String[numberOfRecipes];
		double[][] menuGeneralArray = new double[numberOfRecipes][numberOfIngredients];
		
		for (int j = 0; j < numberOfRecipes; j++) {
			String menuItem = scan.next();
			menuItemsArray[j] = menuItem;
			int numberOfRecipeIngredients = scan.nextInt();
			
			for (int k = 0; k < numberOfRecipeIngredients; k++) {
				String recipeIngredient = scan.next();
				double ouncesRequired = scan.nextDouble();
				
				for (int l = 0; l < ingredientsArray.length; l++) {
					if (recipeIngredient.equals(ingredientsArray[l])) {
						menuGeneralArray[j][l] = ouncesRequired;
					}
				}
			}
		}
		String itemOrder = scan.next();
		while (!"EndOrder".equals(itemOrder)) {
			for (int n = 0; n < menuItemsArray.length; n++) {
				if (itemOrder.equals(menuItemsArray[n])) {
					for (int o = 0; o < numberOfIngredients; o++) {
					finalAmountsArray[o] += menuGeneralArray[n][o];
					}
				}
			}
			itemOrder = scan.next();
		}
		
		
		
		System.out.println("The order will require:");

		
		for (int m = 0; m < numberOfIngredients; m++) {
			System.out.println(String.format("%.2f", finalAmountsArray[m]) + " ounces of " + ingredientsArray[m]);
		}
		
	}
	// You can define helper methods here if needed.
	
}
