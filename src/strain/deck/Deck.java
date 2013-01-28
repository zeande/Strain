package strain.deck;

import java.util.ArrayList;
import java.util.Random;

import strain.exception.DeckEmptyException;
import strain.tile.Tile;

public abstract class Deck {

	/**
	 * The deck of cards.
	 */
	protected ArrayList<Tile> deck;

	/**
	 * The discard pile. This is initially populated.
	 */
	protected ArrayList<Tile> discard;

	public Deck() {
		this.deck = new ArrayList<Tile>();
		this.discard = new ArrayList<Tile>();
		initializeDeck();
		shuffle();
	}

	/**
	 * Puts the specified tile into the discard pile.
	 * 
	 * @param tile
	 *            The tile to put into the discard pile.
	 */
	public abstract void discard(Tile tile);

	/**
	 * Draws a card from the top of the deck.
	 * 
	 * @return The card on the top of the deck.
	 * @throws DeckEmptyException
	 *             Throws a DeckEmptyException if the deck is empty.
	 */
	public Tile draw() throws DeckEmptyException {
		if (isEmpty())
			throw new DeckEmptyException("The deck is empty. Reshuffle the di"
					+ "scard pile to continue.");
		return deck.remove(deck.size() - 1);
	}

	protected abstract void initializeDeck();

	/**
	 * Checks whether the deck of cards is empty.
	 * 
	 * @return True if the deck is empty; otherwise, false.
	 */
	public boolean isEmpty() {
		return deck.size() == 0;
	}

	/**
	 * Creates a new, shuffled deck of cards from the discard pile.
	 */
	public void shuffle() {
		Random rand = new Random();
		ArrayList<Tile> newDeck = new ArrayList<Tile>();
		while (discard.size() > 0) {
			int index = rand.nextInt(discard.size());
			newDeck.add(discard.remove(index));
		}
		deck = newDeck;
		discard = new ArrayList<Tile>();
	}
}
