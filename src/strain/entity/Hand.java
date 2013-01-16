package strain.entity;

import java.util.ArrayList;
import strain.exception.*;

/**
 * Simulates the player's hand of cards.
 * @author zeande
 *
 */
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
			throw new FullHandException("Your hand is already full. In order " +
					"to draw a card, you must first withdraw down to under " +
					capacity + " cards.");
		cards.add(card);
	}
	
	/**
	 * Discards the specified card from the player's hand.
	 * @param card The card to discard.
	 * @throws EmptyHandException Thrown if the player has no cards in hand.
	 * @throws CardNotInHandException Thrown if the specified card is not in
	 * the player's hand.
	 */
	public void discard(Card card) throws EmptyHandException, 
			CardNotInHandException {
		if (size == 0)
			throw new EmptyHandException("Your hand is empty. You must first " +
					"draw a card before you can discard one.");
		if (!cardInHand(card))
			throw new CardNotInHandException("Error! That card is not in the " +
					"player's hand!");
		cards.remove(card);
	}

	/**
	 * Checks whether the specified card is in the player's hand.
	 * @param card The card to check.
	 * @return True if the card is in the player's hand; otherwise, false.
	 */
	private boolean cardInHand(Card card) {
		return cards.contains(card);
	}
}
