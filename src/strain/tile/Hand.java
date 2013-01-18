package strain.tile;

import java.util.ArrayList;
import strain.exception.*;

/**
 * Simulates the player's hand of cards.
 *
 */
public class Hand {
	private ArrayList<Tile> tiles;
	private int capacity = 4;
	private int size = 0;
	
	/**
	 * Default constructor for objects of type Hand.
	 */
	public Hand() {
		tiles = new ArrayList<Tile>();
	}
	
	/**
	 * Adds a card to the player's hand.
	 * @param card The card to add.
	 * @throws FullHandException An exception is thrown if the player's hand
	 * is already full.
	 */
	public void addCard(Tile card) throws FullHandException {
		if (size >= capacity)
			throw new FullHandException("Your hand is already full. In order " +
					"to draw a card, you must first withdraw down to under " +
					capacity + " cards.");
		tiles.add(card);
	}
	
	/**
	 * Discards the specified card from the player's hand.
	 * @param card The card to discard.
	 * @throws EmptyHandException Thrown if the player has no cards in hand.
	 * @throws TileNotInHandException Thrown if the specified card is not in
	 * the player's hand.
	 */
	public Tile discard(Tile card) throws EmptyHandException, 
			TileNotInHandException {
		if (size == 0)
			throw new EmptyHandException("Your hand is empty. You must first " +
					"draw a card before you can discard one.");
		if (!cardInHand(card))
			throw new TileNotInHandException("Error! That card is not in the " +
					"player's hand!");
		tiles.remove(card);
		return card;
	}

	/**
	 * Checks whether the specified card is in the player's hand.
	 * @param card The card to check.
	 * @return True if the card is in the player's hand; otherwise, false.
	 */
	private boolean cardInHand(Tile card) {
		return tiles.contains(card);
	}
}
