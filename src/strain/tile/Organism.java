package strain.tile;

import java.util.ArrayList;

public class Organism extends Tile {

	private int victoryPoints = 0;
	private ArrayList<Tile> membrane;
	
	public Organism(int victoryPoints) {
		this.victoryPoints = victoryPoints;
		membrane = new ArrayList<Tile>();
	}
	
	@Override
	protected boolean applyToxin(int toxin) {
		life -= toxin;
		return life <= 0;
	}
	
	/**
	 * Checks whether the organism's membrane is full.
	 * @return True if the organism's membrane is full; otherwise, false.
	 */
	public boolean isFull() {
		return membrane.size() >= 8;
	}
	
	/**
	 * Checks whether the organism is complete.
	 * @return True if the organism is complete; otherwise, false.
	 */
	public boolean isComplete() {
		return membrane.size() >= victoryPoints;
	}
	
	/**
	 * Gets the number of victory points that this organism is worth.
	 * @return The number of victory points that this organism is worth.
	 */
	public int getVictoryPoints() {
		return victoryPoints;
	}
}
