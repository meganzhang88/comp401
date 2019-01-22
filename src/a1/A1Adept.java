package a1;

import java.util.Scanner;
import java.util.Arrays;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code goes here.
		String biggest = "biggest";
		String smallest = "smallest";
		int itemsInStore = scan.nextInt();
		
		String[] itemsArray = new String[itemsInStore];
		double[] pricesArray = new double[itemsInStore];
		
		for (int i = 0; i < itemsInStore; i++) {
			String nameOfItem = scan.next();
			double price = scan.nextDouble();
			
			itemsArray[i] = nameOfItem;
			pricesArray[i]= price; 
		}
		
		int customers = scan.nextInt();
		double[] totals = new double[customers];
		
		double bigAmount = 0;
		double smallAmount = 0;
		
		for (int i = 0; i < customers; i++) {
		double newTotal = 0;
			String first = scan.next();
			String last = scan.next();
			int itemsBought = scan.nextInt();
			
			for (int j = 0; j < itemsBought; j++) {
				int quantity = scan.nextInt();
				String itemName = scan.next();

				for (int k = 0; k < itemsArray.length; k++) {
					if (itemName.equals(itemsArray[k])) {
						newTotal = newTotal + pricesArray[k] * quantity;
					}
				}
			}

			if (smallAmount == 0) {
				smallAmount = newTotal;
				smallest = first + " " + last;
				totals[i]= newTotal; 
			}
			if (bigAmount == 0) {
				bigAmount = newTotal;
				biggest = first + " " + last;
				totals[i] = newTotal;
			}
			if (newTotal > bigAmount) {
				biggest = first + " " + last;
				bigAmount = newTotal;
				totals[i] = newTotal; 
			} else if (newTotal < smallAmount) {
				smallAmount = newTotal;
				smallest = first + " " + last;
				totals[i] = newTotal;
			} else {
				totals[i] = newTotal;
			}
		}
		
		double sum = 0;
		for (int l = 0; l < totals.length; l++) {
			sum = sum + totals[l];
		}
		
		double average = sum / customers;
		
		System.out.println("Biggest: " + biggest + " (" + String.format("%.2f", bigAmount) + ")");
		System.out.println("Smallest: " + smallest + " (" + String.format("%.2f", smallAmount) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
	
	// You can define / use static helper methods here.
}

