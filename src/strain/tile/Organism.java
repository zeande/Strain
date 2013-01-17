package strain.tile;

public class Organism extends Tile {

	@Override
	protected boolean applyToxin(int toxin) {
		life -= toxin;
		return life <= 0;
	}
}
