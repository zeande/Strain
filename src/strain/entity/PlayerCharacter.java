package strain.entity;

import strain.Engine;
import strain.exception.DeckEmptyException;
import strain.tile.Tile;
import strain.ui.Interactable;

public class PlayerCharacter extends Character {

	public PlayerCharacter(String name, Interactable ui) {
		super(name, ui);
	}

	@Override
	public void declareBattle(Character opponent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawTiles() {
		int drawCount = getDrawCount();
		for (int i = 0; i < drawCount; i++) {
			char d = ui.chooseDeck();
			Tile newTile;
			try {
				newTile = takeTile(d);
			} catch (DeckEmptyException e) {
				System.out.println("Error! Deck is empty!");
				e.printStackTrace();
				return;
			}
			ui.showTile(newTile);
			hand.addCard(newTile);
		}
	}

	private Tile takeTile(char d) throws DeckEmptyException {
		switch (d) {
		case 'C': // Cytoplasm deck
			return Engine.cytoplasmDeck.draw();
		case 'P': // PetriDish deck
			return Engine.petriDishDeck.draw();
		default:  // Organism deck
			return Engine.organismDeck.draw();
		}
	}

	@Override
	protected void endTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void performAwakenPhase() {
		for (Tile t : hand) {
			t.reset();
		}
		drawTiles();
	}

	@Override
	public void performEvolvePhase() {
		// TODO Auto-generated method stub
	}

	@Override
	public void performShedPhase() {
		// TODO Auto-generated method stub
	}
}
