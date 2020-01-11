package sushigame.view;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import comp401sushi.Plate;

public class PlateViewWidget extends JButton implements MouseListener {
	
	private Plate plate;
	private JButton plateButton = null;
	
	public PlateViewWidget(Plate plate) {
		this.plate = plate;
	}
	
	public void actionPerformed(ActionEvent e) {
		remove(this);
	}
	
	private void createBox() {
		JOptionPane.showMessageDialog(null, text(plate), "Plate Information", JOptionPane.PLAIN_MESSAGE);
	}
	
	public String text (Plate plate) {
		
		String sushiName = "";
		String sushiIngredients = "";
		String plateColor = plate.getColor().toString();
		String chefName = plate.getChef().getName();
		
		for (int i = 0; i < plate.getContents().getIngredients().length; i++) {
			if (plate.getContents().getName().contains("sashimi")) {
				sushiName = plate.getContents().getName();
				sushiIngredients = sushiName.replace("sashimi", "") + ": 0.75 oz";
			} else if (plate.getContents().getName().contains("nigiri")) {
				sushiName = plate.getContents().getName();
				sushiIngredients = sushiName.replace("nigiri", "") + ": 0.75 oz, rice: 0.5 oz";
			} else {
				sushiName = plate.getContents().getName();
				sushiIngredients = sushiIngredients + "" + plate.getContents().getIngredients()[i].getName() + ": " + plate.getContents().getIngredients()[i].getAmount()+ " oz ";
			}
		}
		String answer = "Sushi name: " + sushiName + "\n" + plateColor + " plate" + "\n" + "Ingredients: " + sushiIngredients + "\n" + "Chef Name: " + chefName;
		return answer;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		createBox();
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
	}

	@Override
	public void mouseExited(MouseEvent e) {		
	}
	
	

}
