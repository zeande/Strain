package strain.ui;

import java.util.Scanner;

import strain.Engine;
import strain.entity.Character;
import strain.sound.SoundEngine;
import strain.tile.Tile;

public class TextEngine implements Interactable {

	/**
	 * A Scanner object to get user input.
	 */
	private Scanner scan;

	/**
	 * The sound engine used to play background music and effects.
	 */
	private SoundEngine soundEngine;

	public TextEngine(Engine game) {
		scan = new Scanner(System.in);
	}

	public void setPhase(char c) {
		switch (c) {
		case 'A':
			System.out.println("\nAWAKEN PHASE\n");
			break;
		case 'E':
			System.out.println("\nEVOLVE PHASE\n");
			break;
		case 'S':
			System.out.println("\nSHED PHASE\n");
			break;
		}
	}

	@Override
	public void displayWinner(Character winner) {
		System.out.println("\n\nGame Over!\n\n");
		System.out.println(winner + " won!\n\n");
	}

	@Override
	public int getChoice(int min, int max) {
		scan = new Scanner(System.in);
		int choice = min - 1;
		boolean valid = false;
		while (!valid) {
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				choice = min - 1;
				scan = new Scanner(System.in);
			}
			valid = choice >= min && choice <= max;
			if (!valid) {
				System.out.print("Error! Please enter an integer between "
						+ min + " and " + max + " > ");
			}
		}
		return choice;
	}

	@Override
	public int getChoice(String message, int min, int max) {
		scan = new Scanner(System.in);
		System.out.print(message);
		return getChoice(min, max);
	}

	@Override
	public String getResponse(String message) {
		scan = new Scanner(System.in);
		System.out.print(message);
		return scan.nextLine();
	}

	@Override
	public void initialize() {
		soundEngine = new SoundEngine();
		soundEngine.playMusic("INTRO_MUSIC");
	}

	@Override
	public void switchToGameScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToIntroScreen() {
		System.out.println("This is the game of:\n");
		System.out.println(" _____ _             _       \n"
				+ "/  ___| |           (_)\n"
				+ "\\ `--.| |_ _ __ __ _ _ _ __\n"
				+ " `--. \\ __| '__/ _` | | '_ \\\n"
				+ "/\\__/ / |_| | | (_| | | | | |\n"
				+ "\\____/ \\__|_|  \\__,_|_|_| |_|\n");

	}

	@Override
	public char chooseDeck() {
		char choice = ' ';
		scan = new Scanner(System.in);
		System.out.println("From which deck would you like to choose your card?");
		
		while ( "OCP".indexOf(choice) == -1 ) {
			System.out.print("  (O)rganism deck\n" +
					"  (C)ytoplasm deck\n" +
					"  (P)etri Dish deck\n > ");
			try {
				choice = scan.nextLine().charAt(0);
			} catch (Exception e) {
				scan = new Scanner(System.in);
				System.out.println("Error!");
			}
		}
		return choice;
	}

	@Override
	public void showTile(Tile newTile) {
		// TODO Auto-generated method stub
		System.out.println(newTile);
	}
	
	public void showTiles(Character c) {
		System.out.println("These are your tiles:\n");
		for (Tile t : c.getHand()) {
			System.out.println(t);
		}
	}
}
