package strain.ui;

import java.util.Scanner;

import strain.Engine;
import strain.sound.SoundEngine;



public class TextEngine implements Interactable {

	/**
	 * The sound engine used to play background music and effects.
	 */
	private SoundEngine soundEngine;
	
	/**
	 * A Scanner object to get user input.
	 */
	private Scanner scan;
	
	public TextEngine(Engine game) {
		scan = new Scanner(System.in);
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
			valid = (choice >= min && choice <= max);
			if (!valid) {
				System.out.print("Error! Please enter an integer between " +
						min + " and " + max + " > ");
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
		System.out.println(" _____ _             _       \n" + 
						   "/  ___| |           (_)\n" +      
				           "\\ `--.| |_ _ __ __ _ _ _ __\n" +   
				           " `--. \\ __| '__/ _` | | '_ \\\n" +  
				           "/\\__/ / |_| | | (_| | | | | |\n" + 
				           "\\____/ \\__|_|  \\__,_|_|_| |_|\n");
		
	}
}
