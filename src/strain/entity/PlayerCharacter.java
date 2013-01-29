package strain.entity;

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
