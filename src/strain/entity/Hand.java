package strain.entity;

import java.util.ArrayList;
import strain.exception.*;

public class Hand {
	private ArrayList<Card> cards;
	private int capacity = 4;
	private int size = 0;
	
	/**
	 * Adds a card to the player's hand.
	 * @param card The card to add.
	 * @throws FullHandException An exception is thrown if the player's hand
	 * is already full.
	 */
	public void addCard(Card card) throws FullHandException {
		if (size >= capacity)
			throw new FullHandException("Your hand is already full. Withdraw "
					+ "to under " + capacity + " cards to draw another.");
		cards.add(card);
	}
}
