package strain.tile;

public abstract class Tile {
	protected String name;
	private int resistance_up;
	private int resistance_down;
	protected int resistance;
	protected int life;
	
	public Tile(int resistance, int resistance_up, int resistance_down) {
		this.resistance = resistance;
		this.resistance_up = resistance_up;
		this.resistance_down = resistance_down;
	}
	
	public Tile() {
		
	}
	
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
	
	protected abstract void discard();
}
