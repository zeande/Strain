package strain.entity;

import java.util.ArrayList;
import strain.exception.OrganismIncompleteException;
import strain.exception.OrganismNotInPlayException;
import strain.tile.Hand;
import strain.tile.Organism;

public abstract class Player {
	
	private int score;
	private Hand hand;
	private ArrayList<Organism> organismsInPlay;
	private ArrayList<Organism> completedOrganisms;
	public String name;
	
	public Player(String name) {
		this.hand = new Hand();
		this.name = name;
		this.score = 0;
		this.organismsInPlay = new ArrayList<Organism>();
		this.completedOrganisms = new ArrayList<Organism>();
	}
	
	public abstract void declareBattle(Player opponent);
	
	public abstract void endTurn();
	
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
		organismsInPlay.remove(tile);
		completedOrganisms.add(tile);
		
		return score >= 12;
	}
}
