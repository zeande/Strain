package strain;

import strain.sound.SoundEngine;
import strain.ui.Interactable;
import strain.ui.TextEngine;
import strain.deck.CytoplasmDeck;
import strain.deck.OrganismDeck;
import strain.deck.PetriDishDeck;
import strain.entity.Player;

public class Engine implements Runnable {
	
	private static OrganismDeck organismDeck;
	private static CytoplasmDeck cytoplasmDeck;
	private static PetriDishDeck petriDishDeck;
	private static Interactable ui;
	private Player[] players;
	
	public Engine() {
		ui = new TextEngine(this);
	}
	
	public static void main(String[] args) {
		Engine game = new Engine();
		game.run();
	}
	
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
	}
	
	public void establishPlayers() {
		int numPlayers = ui.getChoice("Number of players (3-7) > ",3,7);
		this.players = new Player[numPlayers];
	}
}
