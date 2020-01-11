package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numberOfIngredients = scan.nextInt();
		String[] ingredientsArray = new String[numberOfIngredients];
		double[] pricesArray = new double[numberOfIngredients];
		boolean[] isVegetarianArray = new boolean[numberOfIngredients];
		int[] caloriesArray = new int[numberOfIngredients];
		
		
		for (int i = 0; i < numberOfIngredients; i++) {
			String ingredient = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			
			ingredientsArray[i] = ingredient;
			pricesArray[i] = pricePerOunce;
			isVegetarianArray[i] = isVegetarian;
			caloriesArray[i] = caloriesPerOunce;
		}
		
		int numberOfRecipes = scan.nextInt();
		double[] recipesCaloriesArray = new double[numberOfRecipes];
		double[] recipeCostsArray = new double[numberOfRecipes];
		String[] menuItemsArray = new String[numberOfRecipes];
		
		for (int j = 0; j < numberOfRecipes; j++) {
			String menuItem = scan.next();
			menuItemsArray[j] = menuItem;
			int ingredientsInRecipe = scan.nextInt();
			String answer = "Vegetarian";
			boolean vegetarianIngredient = true;
			
			for (int k = 0; k < ingredientsInRecipe; k++) {
				String recipeIngredient = scan.next();
				double ouncesRequired = scan.nextDouble();
				
				for (int l = 0; l < ingredientsArray.length; l++) {
					if (recipeIngredient.equals(ingredientsArray[l])) {
						recipesCaloriesArray[j] += caloriesArray[l] * ouncesRequired;
						recipeCostsArray[j] += pricesArray[l] * ouncesRequired;
						
						if (isVegetarianArray[l] == false) {
							vegetarianIngredient = false;
							answer = "Non-Vegetarian";
						}
					}
				}
			}
			
			System.out.println(menuItemsArray[j] + ":");
			System.out.println("  " + (int) (recipesCaloriesArray[j] + 0.5) + " calories");
			System.out.println("  " + "$" + String.format("%.2f", recipeCostsArray[j]));
			System.out.println("  " + answer);
		}
		
	}
	
	// You can define helper methods here if needed.
	
}
