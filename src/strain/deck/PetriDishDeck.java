package strain.deck;

import strain.tile.Tile;
import strain.tile.PetriDish;

public class PetriDishDeck extends Deck {
	
	private static final int NO_CARDS = 80;
	
	@Override
	public void discard(Tile tile) {
		discard.add((PetriDish) tile);
	}

	@Override
	protected void initializeDeck() {
		// TODO Make this more specific!
		for (int i = 0; i < NO_CARDS; i++)
			discard(new PetriDish(1));
	}

}
