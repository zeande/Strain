package strain;

import strain.sound.SoundEngine;
import strain.deck.CytoplasmDeck;
import strain.deck.OrganismDeck;
import strain.deck.PetriDishDeck;

public class Engine {
	
	private static OrganismDeck organismDeck;
	private static CytoplasmDeck cytoplasmDeck;
	private static PetriDishDeck petriDishDeck;
	
	public static void main(String[] args) {
		
		Engine game = new Engine();
		game.initialize();
		
		SoundEngine music = new SoundEngine();
		music.playMusic("INTRO_MUSIC");
	}
	
	public void initialize() {
		organismDeck = new OrganismDeck();
		cytoplasmDeck = new CytoplasmDeck();
		petriDishDeck = new PetriDishDeck();
	}
	
}
