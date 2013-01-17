package strain.tile;

public class PetriDish extends Tile {

	@Override
	protected boolean applyToxin(int toxin) {
		life -= toxin;
		return life <= 0;
	}
}
