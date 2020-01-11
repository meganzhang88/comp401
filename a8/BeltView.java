package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;
	private PlateViewWidget[] plateViewWidgetArray;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_labels = new JLabel[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(300, 20));
			plabel.setPreferredSize(new Dimension(300, 20));
			plabel.setOpaque(true);
			plabel.setBackground(Color.GRAY);
			add(plabel);
			belt_labels[i] = plabel;
		}
		this.plateViewWidgetArray = new PlateViewWidget[belt.getSize()];
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		for (int i = 0; i < belt_labels.length; i++) {
			belt_labels[i].removeMouseListener(plateViewWidgetArray[i]);
		}
		refresh();
	}

	private void refresh() {
		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];

			if (p == null) {
				plabel.setText("No Plate");
				plabel.setBackground(Color.GRAY);
			} else {
				plabel.setText("Click Me!                            " + p.getContents().getName().toString() + " Age: " + belt.getAgeOfPlateAtPosition(i));
				plateViewWidgetArray[i] = new PlateViewWidget(p);
				plabel.addMouseListener(plateViewWidgetArray[i]);
				switch (p.getColor()) {
				case RED:
					plabel.setBackground(Color.RED); break;
				case GREEN:
					plabel.setBackground(Color.GREEN); break;
				case BLUE:
					plabel.setBackground(Color.BLUE); break;
				case GOLD:
					plabel.setBackground(Color.YELLOW); break;
				}
			}
		}
	}
}
