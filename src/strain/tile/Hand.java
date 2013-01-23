package strain.tile;

import java.util.ArrayList;
import strain.exception.*;

/**
 * Simulates the player's hand of tiles.
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
	 * Adds a tile to the player's hand.
	 * @param tile The tile to add.
	 * @throws FullHandException An exception is thrown if the player's hand
	 * is already full.
	 */
	public void addCard(Tile tile) throws FullHandException {
		if (size >= capacity)
			throw new FullHandException("Your hand is already full. In order " +
					"to draw a tile, you must first withdraw down to under " +
					capacity + " tiles.");
		tiles.add(tile);
	}
	
	/**
	 * Discards the specified tile from the player's hand.
	 * @param tile The tile to discard.
	 * @throws EmptyHandException Thrown if the player has no tiles in hand.
	 * @throws TileNotInHandException Thrown if the specified tile is not in
	 * the player's hand.
	 */
	public Tile discard(Tile tile) throws EmptyHandException, 
			TileNotInHandException {
		if (size == 0)
			throw new EmptyHandException("Your hand is empty. You must first " +
					"draw a tile before you can discard one.");
		if (!tileInHand(tile))
			throw new TileNotInHandException("Error! That tile is not in the " +
					"player's hand!");
		tiles.remove(tile);
		return tile;
	}

	/**
	 * Checks whether the specified tile is in the player's hand.
	 * @param tile The tile to check.
	 * @return True if the tile is in the player's hand; otherwise, false.
	 */
	private boolean tileInHand(Tile tile) {
		return tiles.contains(tile);
	}
}
