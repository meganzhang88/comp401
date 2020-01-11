package a7;


import java.util.ArrayList;

import comp401sushi.Plate;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	private ArrayList<BeltObserver> beltObservers = new ArrayList<BeltObserver>();
	private ArrayList<Customer> beltCustomers = new ArrayList<Customer>();
	
	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		_belt = new Plate[belt_size];
	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		_belt[position] = plate;
		PlateEvent plateEvent = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position);
		for (int i = 0; i < beltObservers.size(); i++) {
			beltObservers.get(i).handlePlateEvent(plateEvent);
		}
	}


	@Override
	public void clearPlateAtPosition(int position) {
		position = normalize_position(position);
		Plate plateCleared = _belt[position];
		
		_belt[position] = null;		

		PlateEvent plateEvent = new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, plateCleared , position);
		for (int i = 0; i < beltObservers.size(); i++) {
			beltObservers.get(i).handlePlateEvent(plateEvent);
		}
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}
	
	
	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);
				
				PlateEvent plateEvent = new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate , position+offset);
				for (int i = 0; i < beltObservers.size(); i++) {
					beltObservers.get(i).handlePlateEvent(plateEvent);
				}

				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i=getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
			beltCustomers.get(i).observePlateOnBelt(_belt, _belt[i-1], i);
		}
		_belt[0] = last_plate;
		beltCustomers.get(0).observePlateOnBelt(_belt, last_plate , 0);
		
	}

	@Override
	public void addBeltObserver(BeltObserver o) {
		beltObservers.add(o);	
	}

	@Override
	public void removeBeltObserver(BeltObserver o) {
		beltObservers.remove(o);	
	}

	@Override
	public void registerCustomerAtPosition(Customer c, int position) {
		position = normalize_position(position);
		if (beltCustomers.size() == 0) {
			System.exit(0);
		}
		if (c == null) {
			throw new IllegalArgumentException("Customer can not be null");
		}
		if (beltCustomers.get(position) != null) {
			throw new RuntimeException("Posiiton is already registered with a different Customer");
		} else {
			for (int i = 0; i < beltCustomers.size(); i++) {
				if (beltCustomers.get(i) == c) {
					throw new RuntimeException("Customer is already registered at a different position");
				}
			}
			beltCustomers.set(position, c);
		}
	}
	
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		if (beltCustomers.size() == 0) {
			return null;
		}
		if (beltCustomers.get(position) == null) {
			return null;
		} else {
			Customer removedCustomer = beltCustomers.get(position);
			beltCustomers.set(position,  null);
			return removedCustomer;
		}
	}
}
