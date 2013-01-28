package strain.entity;

import java.util.ArrayList;
import java.util.Iterator;

import strain.exception.CardNotInHandException;
import strain.exception.EmptyHandException;
import strain.exception.FullHandException;
import strain.exception.TileNotInHandException;
import strain.tile.Tile;

/**
 * Simulates the player's hand of cards.
 * 
 */
public class Hand implements Iterable<Tile> {

	private int capacity = 4;
	private int size = 0;
	private ArrayList<Tile> tiles;

	public Hand() {
		tiles = new ArrayList<Tile>();
	}

	/**
	 * Adds a card to the player's hand.
	 * 
	 * @param card
	 *            The card to add.
	 * @throws FullHandException
	 *             An exception is thrown if the player's hand is already full.
	 */
	public void addCard(Tile tile) throws FullHandException {
		if (size >= capacity)
			throw new FullHandException("Your hand is already full. In order "
					+ "to draw a card, you must first withdraw down to under "
					+ capacity + " cards.");
		tiles.add(tile);
		size++;
	}

	/**
	 * Discards the specified card from the player's hand.
	 * 
	 * @param card
	 *            The card to discard.
	 * @throws EmptyHandException
	 *             Thrown if the player has no cards in hand.
	 * @throws CardNotInHandException
	 *             Thrown if the specified card is not in the player's hand.
	 */
	public void discard(Tile tile) throws EmptyHandException,
			TileNotInHandException {
		if (size == 0)
			throw new EmptyHandException("Your hand is empty. You must first "
					+ "draw a card before you can discard one.");
		if (!tileInHand(tile))
			throw new TileNotInHandException("Error! That card is not in the "
					+ "player's hand!");
		tiles.remove(tile);
		size--;
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	/**
	 * Checks whether the specified card is in the player's hand.
	 * 
	 * @param card
	 *            The card to check.
	 * @return True if the card is in the player's hand; otherwise, false.
	 */
	private boolean tileInHand(Tile tile) {
		return tiles.contains(tile);
	}
}
