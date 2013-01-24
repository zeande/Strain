package strain.ui;

public interface Interactable {
	
	public void initialize();
	
	public int getChoice(int min, int max);
	
	public int getChoice(String message, int min, int max);
	
	public String getResponse(String message);
	
	public void switchToIntroScreen();
	
	public void switchToGameScreen();
	
}
