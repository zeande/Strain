package strain.tile;

public abstract class Tile {
	protected String name;
	private int resistance_up;
	private int resistance_down;
	protected int resistance;
	protected int life;
	
	protected void turnDown() {
		resistance = resistance_down;
	}
	
	protected void turnUp() {
		resistance = resistance_up;
	}
	
	protected int getResistance() {
		return resistance;
	}
	
	/**
	 * Applies the specified amount of toxin to the tile.
	 * @param toxin The amount of toxin to apply.
	 * @return True if the tile is killed; otherwise, false.
	 */
	protected abstract boolean applyToxin(int toxin);
	
	protected void reset() {
		life = resistance;
	}
	
}
