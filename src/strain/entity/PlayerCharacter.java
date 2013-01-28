package strain.entity;

import strain.tile.Tile;

public class PlayerCharacter extends Character {

	public PlayerCharacter(String name) {
		super(name);
	}

	@Override
	public void declareBattle(Character opponent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawTiles() {
		for (int i = 0; i < getDrawCount(); i++) {
			// TODO Implement a way to draw tiles
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
