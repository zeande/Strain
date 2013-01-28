package strain.deck;

import strain.tile.Organism;
import strain.tile.Tile;

public class OrganismDeck extends Deck {

	private static final int NO_2 = 10;
	private static final int NO_4 = 10;
	private static final int NO_6 = 10;
	private static final int NO_8 = 10;

	@Override
	public void discard(Tile tile) {
		discard.add(tile);
	}

	@Override
	protected void initializeDeck() {
		for (int i = 0; i < NO_2; i++) {
			discard(new Organism(2));
		}
		for (int i = 0; i < NO_4; i++) {
			discard(new Organism(4));
		}
		for (int i = 0; i < NO_6; i++) {
			discard(new Organism(6));
		}
		for (int i = 0; i < NO_8; i++) {
			discard(new Organism(8));
		}
	}

}
