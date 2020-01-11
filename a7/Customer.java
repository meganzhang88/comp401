package a7;

import comp401sushi.Plate;

public interface Customer {
	void observePlateOnBelt(Belt _belt, Plate p, int position);

	void observePlateOnBelt(Plate[] _belt, Plate p, int position);
}
