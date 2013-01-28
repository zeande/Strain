package strain;

import java.util.Random;

import strain.deck.CytoplasmDeck;
import strain.deck.OrganismDeck;
import strain.deck.PetriDishDeck;
import strain.entity.Character;
import strain.entity.PlayerCharacter;
import strain.ui.Interactable;
import strain.ui.TextEngine;

public class Engine implements Runnable {

	/**
	 * The decks of tiles for the game.
	 */
	public static CytoplasmDeck cytoplasmDeck;
	public static OrganismDeck organismDeck;
	public static PetriDishDeck petriDishDeck;

	/**
	 * Indicates the phase
	 */
	public static String phase;

	public static final int POINTS_TO_WIN = 12;

	/**
	 * The interface object that the game will use.
	 */
	private static Interactable ui;

	public static void main(String[] args) {
		Engine game = new Engine();
		game.run();
	}

	/**
	 * The status of whether the game has been finished.
	 */
	private boolean gameFinished = false;

	/**
	 * The players that will be in the game.
	 */
	private Character[] players;

	/**
	 * The index of the player whose turn it is.
	 */
	private int turn;

	public Engine() {
		ui = new TextEngine(this);
	}

	/**
	 * Initializes the players based on the user input.
	 */
	public void establishPlayers() {
		int numPlayers = ui.getChoice("Number of players (3-7) > ", 3, 7);
		players = new Character[numPlayers];
		for (int i = 1; i <= numPlayers; i++) {
			String name = ui.getResponse("Enter the name of player " + i
					+ " > ");
			players[i - 1] = new PlayerCharacter(name);
		}
		turn = new Random().nextInt(numPlayers);
	}

	/**
	 * Initializes required components of the game.
	 */
	public void initialize() {
		organismDeck = new OrganismDeck();
		cytoplasmDeck = new CytoplasmDeck();
		petriDishDeck = new PetriDishDeck();
	}

	/**
	 * Game loop.
	 */
	private void playGame() {
		int score;
		while (true) {
			score = players[turn].playTurn(ui);
			gameFinished = score >= POINTS_TO_WIN;
			if (gameFinished) {
				break;
			}
			turn = (turn + 1) % players.length;
		}
		ui.displayWinner(players[turn]);
	}

	@Override
	public void run() {
		initialize();
		ui.initialize();
		ui.switchToIntroScreen();
		establishPlayers();
		playGame();
	}
}
