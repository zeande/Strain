package strain.entity;

import java.util.ArrayList;

import strain.exception.OrganismIncompleteException;
import strain.exception.OrganismNotInPlayException;
import strain.tile.Organism;
import strain.tile.Tile;
import strain.ui.Interactable;

public abstract class Character {

	private static final int DRAW_COUNT = 3;
	private ArrayList<Organism> completedOrganisms;
	protected Hand hand;
	public String name;
	private ArrayList<Organism> organismsInPlay;
	protected int score;
	protected Interactable ui;

	public Character(String name, Interactable ui) {
		this.hand = new Hand();
		this.name = name;
		this.score = 0;
		this.ui = ui;
		this.organismsInPlay = new ArrayList<Organism>();
		this.completedOrganisms = new ArrayList<Organism>();
	}

	public abstract void declareBattle(Character opponent);

	public abstract void drawTiles();

	protected abstract void endTurn();

	public int getDrawCount() {

		int drawCount = DRAW_COUNT;
		for (Organism org : organismsInPlay) {
			for (@SuppressWarnings("unused")
			Tile t : org.membrane) {
				// TODO Implement something to get the draw count bonus.
			}
		}

		return drawCount;
	}

	public abstract void performAwakenPhase();

	public abstract void performEvolvePhase();

	public abstract void performShedPhase();

	/**
	 * Executes a player's turn.
	 * 
	 * @return The score of the player upon finishing her turn.
	 */
	public int playTurn(Interactable ui) {
		ui.displayPhase('A');
		performAwakenPhase();

		ui.displayPhase('E');
		performEvolvePhase();

		ui.displayPhase('S');
		performShedPhase();
		endTurn();
		return score;
	}

	/**
	 * Scores the specified organism tile.
	 * 
	 * @param tile
	 *            The organism to score.
	 * @return True if the player has won the game; otherwise, false.
	 * @throws OrganismIncompleteException
	 *             if the specified organism is not yet complete.
	 * @throws OrganismNotInPlayException
	 *             if the specified organism is not in play.
	 */
	public void scoreOrganism(Organism tile)
			throws OrganismIncompleteException, OrganismNotInPlayException {

		if (!tile.isComplete())
			throw new OrganismIncompleteException("This organism is not yet c"
					+ "omplete! Complete organism before scoring it.");
		if (!organismsInPlay.contains(tile))
			throw new OrganismNotInPlayException("Error! This organism is not"
					+ " in play!");

		score += tile.getVictoryPoints();

		organismsInPlay.remove(tile);
		completedOrganisms.add(tile);
	}

	@Override
	public String toString() {
		return name;
	}
}
