package a6;

// Created a Plate interface

public interface Plate {
	
	   public enum Color {RED, GREEN, BLUE, GOLD};
	   Sushi getContents(); 
	   Sushi removeContents(); 
	   void setContents(Sushi s) throws PlatePriceException; 
	   boolean hasContents(); 
	   double getPrice(); 
	   Plate.Color getColor(); 
	   double getProfit(); 

}
