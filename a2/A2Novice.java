package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int numberOfIngredients = scan.nextInt();
		int veggieIngredients = 0;
		double highestCals = 0;
		double lowestCals = 0;
		String highestCalsIngredient = "default";
		String lowestCalsIngredient = "default";
		
		for (int i = 0; i < numberOfIngredients; i++) {
			String ingredient = scan.next();
			double pricePerOunce = scan.nextDouble();
			boolean isVegetarian = scan.nextBoolean();
			int caloriesPerOunce = scan.nextInt();
			double caloriesPerDollar = 1 / pricePerOunce * caloriesPerOunce;
			
			if (isVegetarian) {
				veggieIngredients++;
			}
			
			if (highestCals == 0) {
				highestCals = caloriesPerDollar;
				highestCalsIngredient = ingredient;
			}
			
			if (lowestCals == 0) {
				lowestCals = caloriesPerDollar;
				lowestCalsIngredient = ingredient;
			}
			
			if (caloriesPerDollar > highestCals) {
				highestCals = caloriesPerDollar;
				highestCalsIngredient = ingredient;
			} else if (caloriesPerDollar < lowestCals) {
				lowestCals = caloriesPerDollar;
				lowestCalsIngredient = ingredient;
			}
		}
		System.out.println("Number of vegetarian ingredients: " + veggieIngredients);
		System.out.println("Highest cals/$: " + highestCalsIngredient);
		System.out.println("Lowest cals/$: " + lowestCalsIngredient);
	}
	
	// You can define helper methods here if needed.
	
}
