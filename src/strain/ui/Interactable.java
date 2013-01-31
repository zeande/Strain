package strain.ui;

import strain.entity.Character;
import strain.tile.Tile;

/**
 * 
 * The Interactable interface is used with the Engine to provide a modular way
 * of providing a user interface.
 * 
 */
public interface Interactable {

	public void setPhase(char c);

	public void displayWinner(Character winner);

	/**
	 * Gets a choice from the user that is between min and max.
	 * 
	 * @param min
	 *            The minimum integer to choose.
	 * @param max
	 *            The maximum integer to choose.
	 * @return The user's choice.
	 */
	public int getChoice(int min, int max);

	/**
	 * Gets a choice from the user after displaying a message.
	 * 
	 * @param message
	 *            The message to tell the user.
	 * @param min
	 *            The minimum integer to choose.
	 * @param max
	 *            The maximum integer to choose.
	 * @return The user's choice.
	 */
	public int getChoice(String message, int min, int max);

	/**
	 * Gives a message to and gets a response from the user.
	 * 
	 * @param message
	 *            The message to tell the user.
	 * @return The user's response.
	 */
	public String getResponse(String message);

	/**
	 * Initializes the user interface.
	 */
	public void initialize();

	/**
	 * Displays the game screen.
	 */
	public void switchToGameScreen();

	/**
	 * Displays the intro screen.
	 */
	public void switchToIntroScreen();
	
	/**
	 * Lets the player choose which deck from which to draw.
	 * @return A character representation of the deck choice. 
	 */
	public char chooseDeck();

	public void showTile(Tile newTile);

}
