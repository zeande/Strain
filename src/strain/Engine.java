package strain;

import java.util.Random;
import strain.ui.Interactable;
import strain.ui.TextEngine;
import strain.deck.CytoplasmDeck;
import strain.deck.OrganismDeck;
import strain.deck.PetriDishDeck;
import strain.entity.Character;
import strain.entity.PlayerCharacter;

public class Engine implements Runnable {
	
	/**
	 * The decks of tiles for the game.
	 */
	public static OrganismDeck organismDeck;
	public static CytoplasmDeck cytoplasmDeck;
	public static PetriDishDeck petriDishDeck;
	
	public static final int POINTS_TO_WIN = 12;
	
	public static String phase;
	
	/**
	 * The interface object that the game will use.
	 */
	private static Interactable ui;
	
	/**
	 * The players that will be in the game.
	 */
	private Character[] players;
	
	/**
	 * The index of the player whose turn it is.
	 */
	private int turn;
	
	/**
	 * The status of whether the game has been finished.
	 */
	private boolean gameFinished = false;
	
	public Engine() {
		ui = new TextEngine(this);
	}
	
	public static void main(String[] args) {
		Engine game = new Engine();
		game.run();
	}
	
	/**
	 * Initializes required components of the game.
	 */
	public void initialize() {
		organismDeck = new OrganismDeck();
		cytoplasmDeck = new CytoplasmDeck();
		petriDishDeck = new PetriDishDeck();
	}

	@Override
	public void run() {
		initialize();
		ui.initialize();
		ui.switchToIntroScreen();
		establishPlayers();
		playGame();
	}
	
	/**
	 * Game loop.
	 */
	private void playGame() {
		int score;
		while (true) {
			score = players[turn].playTurn(ui);
			gameFinished = (score >= POINTS_TO_WIN);
			if (gameFinished)
				break;
			turn = (turn + 1) % players.length;
		}
		ui.displayWinner(players[turn]);
	}

	/**
	 * Initializes the players based on the user input.
	 */
	public void establishPlayers() {
		int numPlayers = ui.getChoice("Number of players (3-7) > ",3,7);
		players = new Character[numPlayers];
		for (int i = 1; i <= numPlayers; i++) {
			String name = ui.getResponse("Enter the name of player " + i + " > ");
			players[i-1] = new PlayerCharacter(name);
		}
		turn = (new Random()).nextInt(numPlayers);
	}
}
