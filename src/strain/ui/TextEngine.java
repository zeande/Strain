package strain.ui;

import java.util.Scanner;



public class TextEngine implements Interactable {

	Scanner scan;
	
	public TextEngine() {
		scan = new Scanner(System.in);
		initialize();
	}
	
	
	@Override
	public int getChoice(int min, int max) {
		int choice = min - 1;
		boolean valid = false;
		while (!valid) {
			try {
				scan.nextInt();
			} catch (Exception e) {
				choice = min - 1;
				scan = new Scanner(System.in);
			}
			valid = (choice >= min && choice <= max);
			if (!valid) {
				System.out.println("Error! Please enter an integer between " +
						min + " and " + max + ".");
			}
		}
		return choice;
	}

	@Override
	public int getChoice(String message, int min, int max) {
		System.out.println(message);
		return getChoice(min, max);
	}

	@Override
	public String getResponse(String message) {
		System.out.print(message);
		return scan.nextLine();
	}

	@Override
	public void initialize() {
		System.out.println("This is the game of:\n");
		System.out.println(" _____ _             _       \n" + 
						   "/  ___| |           (_)\n" +      
				           "\\ `--.| |_ _ __ __ _ _ _ __\n" +   
				           " `--. \\ __| '__/ _` | | '_ \\\n" +  
				           "/\\__/ / |_| | | (_| | | | | |\n" + 
				           "\\____/ \\__|_|  \\__,_|_|_| |_|)\n");
	}

	@Override
	public void switchToGameScreen() {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToIntroScreen() {
		// TODO Auto-generated method stub

	}

}
