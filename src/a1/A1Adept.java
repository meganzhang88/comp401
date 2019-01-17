package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// Your code goes here.
		scan.next();
		char firstLetter = scan.next().charAt(0);
		scan.next();
		scan.next();
		int bananas = scan.nextInt()
		scan.next();
		double bananasCost = scan.nextDouble();
		
		System.out.println(firstLetter);
		System.out.println(bananas * bananasCost);
	}
	
	// You can define / use static helper methods here.
}
