package strain.tile;

import java.util.ArrayList;

public class Organism extends Tile {

	public ArrayList<Tile> membrane;
	private int victoryPoints = 0;

	public Organism(int victoryPoints) {
		super("Organism",2,2,0);
		this.victoryPoints = victoryPoints;
		membrane = new ArrayList<Tile>();
		this.type = "Organism";
	}

	@Override
	protected boolean applyToxin(int toxin) {
		life -= toxin;
		return life <= 0;
	}

	public ArrayList<Tile> clearMembrane() {
		ArrayList<Tile> membrane = this.membrane;
		this.membrane = new ArrayList<Tile>();
		return membrane;
	}

	@Override
	protected void discard() {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the number of victory points that this organism is worth.
	 * 
	 * @return The number of victory points that this organism is worth.
	 */
	public int getVictoryPoints() {
		return victoryPoints;
	}

	/**
	 * Checks whether the organism is complete.
	 * 
	 * @return True if the organism is complete; otherwise, false.
	 */
	public boolean isComplete() {
		return membrane.size() >= victoryPoints;
	}

	/**
	 * Checks whether the organism's membrane is full.
	 * 
	 * @return True if the organism's membrane is full; otherwise, false.
	 */
	public boolean isFull() {
		return membrane.size() >= 8;
	}

	@Override
	public String toString() {
		String orgString = "************\n";
		orgString +=       "* Organism *\n";
		orgString +=       "*          *\n";
		orgString +=       "*    " + victoryPoints + "     *\n";
		orgString +=       "*          *\n";
		orgString +=       "************\n";
		return orgString;
	}
	
}
