package a7;

// A ProfitCounter object keeps track of the profit associated with all of the plates currently on a belt.
// ProfitCounter should have the following constructor:

public class ProfitCounter implements BeltObserver {
	private double profit;
	private int plateNum;

	public ProfitCounter(Belt b) {
		if (b == null) {
			throw new IllegalArgumentException("Belt can not be null");
		} else {
			b.addBeltObserver(this);
		}
		for (int i = 0; i < b.getSize(); i++) {
			if (b.getPlateAtPosition(i) == null) {
				continue;
			}
			profit += b.getPlateAtPosition(i).getProfit();
			plateNum += 1;
		}
//		totalBeltProfit = profit;
	}
	
	@Override
	public void handlePlateEvent(PlateEvent e) {
		if (e.getType() == PlateEvent.EventType.PLATE_REMOVED) {
			profit -= e.getPlate().getProfit();
			plateNum -= 1;
		} else {
			profit += e.getPlate().getProfit();
			plateNum = plateNum + 1;
		}
	}
	
	public double getTotalBeltProfit() {
		return profit;
	}
	
	public double getAverageBeltProfit() {
		if (plateNum == 0) {
			return 0.0;
		} else {
			return profit / plateNum;
		}
	}

}