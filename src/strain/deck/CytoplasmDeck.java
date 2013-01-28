package strain.deck;

import strain.tile.Cytoplasm;
import strain.tile.Tile;

public class CytoplasmDeck extends Deck {

	private static final int CYTOSKELETON_COUNT = 15;
	private static final int CYTOSOL_COUNT = 50;
	private static final int ECTOPLASM_COUNT = 15;

	@Override
	public void discard(Tile tile) {
		discard.add(tile);
	}

	@Override
	protected void initializeDeck() {
		for (int i = 0; i < CYTOSOL_COUNT; i++) {
			discard(new Cytoplasm("Cytosol", 1, 1, 2));
		}

		for (int i = 0; i < ECTOPLASM_COUNT; i++) {
			discard(new Cytoplasm("Ectoplasm", 2, 2, 2));
		}

		for (int i = 0; i < CYTOSKELETON_COUNT; i++) {
			discard(new Cytoplasm("Cytoskeleton", 0, 0, 3));
		}
	}

}
