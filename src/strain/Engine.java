package strain;

import strain.sound.SoundEngine;

public class Engine {
	
	public static void main(String[] args) { 
		SoundEngine music = new SoundEngine();
		music.playMusic("INTRO_MUSIC");
	}
}
