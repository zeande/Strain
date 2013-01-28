package strain.entity;

import java.util.ArrayList;
import strain.exception.OrganismIncompleteException;
import strain.exception.OrganismNotInPlayException;
import strain.entity.Hand;
import strain.tile.Organism;
import strain.tile.Tile;
import strain.ui.Interactable;

public abstract class Character {
	
	private static final int DRAW_COUNT = 3;
	protected int score;
	protected Hand hand;
	private ArrayList<Organism> organismsInPlay;
	private ArrayList<Organism> completedOrganisms;
	public String name;
	
	public Character(String name) {
		this.hand = new Hand();
		this.name = name;
		this.score = 0;
		this.organismsInPlay = new ArrayList<Organism>();
		this.completedOrganisms = new ArrayList<Organism>();
	}
	
	public String toString() {
		return name;
	}
	
	public abstract void declareBattle(Character opponent);
	
	protected abstract void endTurn();
	
	/**
	 * Scores the specified organism tile.
	 * @param tile The organism to score.
	 * @return True if the player has won the game; otherwise, false.
	 * @throws OrganismIncompleteException if the specified organism
	 * 		is not yet complete.
	 * @throws OrganismNotInPlayException if the specified organism is not in
	 * 		play. 
	 */
	public boolean scoreOrganism(Organism tile) throws 
			OrganismIncompleteException, OrganismNotInPlayException {
		
		if (!tile.isComplete())
			throw new OrganismIncompleteException("This organism is not yet c" +
					"omplete! Complete organism before scoring it.");
		if (!organismsInPlay.contains(tile))
			throw new OrganismNotInPlayException("Error! This organism is not" +
					" in play!");
		
		score += tile.getVictoryPoints();
		//tile.clear
		organismsInPlay.remove(tile);
		completedOrganisms.add(tile);
		
		return score >= 12;
	}
	
//	public Hand getHand() {
//		return hand;
//	}

	/**
	 * Executes a player's turn.
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
	
	public abstract void performAwakenPhase();
	
	public abstract void performEvolvePhase();
	
	public abstract void performShedPhase();
	
	public abstract void drawTiles();
	
	public int getDrawCount() {
		
		int drawCount = DRAW_COUNT;
		for ( Organism org : organismsInPlay ) {
			for ( @SuppressWarnings("unused") Tile t : org.membrane ) {
				//TODO Implement something to get the draw count bonus.
			}
		}
		
		return drawCount;
	}
}
