package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code goes here.
		int numberOfItems = scan.nextInt();
		String[] itemsArray = new String[numberOfItems];
		double[] pricesArray = new double[numberOfItems];
		int[] finalItemNumber = new int[numberOfItems];
		int[] finalCustomersNumber = new int[numberOfItems];
		
		for (int i = 0; i < numberOfItems; i++) {
			itemsArray[i] = scan.next();
			pricesArray[i] = scan.nextDouble();
		}
		
		int numberOfCustomers = scan.nextInt();
		
		for (int j = 0; j < numberOfCustomers; j++) {
			String firstName = scan.next();
			String lastName = scan.next();
			int numberOfItemsBought = scan.nextInt();
			boolean[] exists = new boolean[numberOfItems];
			
			String[] customerProductsArray = new String[numberOfItemsBought];
			
			for (int k = 0; k < numberOfItemsBought; k++) {
				int quantityOfItem = scan.nextInt();
				String itemBought = scan.next();
				
				for (int l = 0; l < itemsArray.length; l++) {
					if (itemBought.equals(itemsArray[l])) {
						finalItemNumber[l] += quantityOfItem;
						customerProductsArray[k] = itemBought;
						exists[l] = true;
					}
				}
			}
			for (int p = 0; p < numberOfItems; p++) {
				if (exists[p]) {
					finalCustomersNumber[p] += 1;
				}
			}
		}
		
		for (int b = 0; b < numberOfItems; b++) {
			if (finalItemNumber[b] == 0) {
				System.out.println("No customers bought " + itemsArray[b]);
			} else {
				System.out.println(finalCustomersNumber[b] + " customers bought " + finalItemNumber[b] + " " + itemsArray[b]);
			}
		}
	}
	
	// You can define / use static helper methods here.
}

