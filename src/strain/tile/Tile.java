package strain.tile;

public abstract class Tile {
	private boolean dormant = false;
	protected int life;
	protected String name;
	protected int resistance;
	private int resistance_down;
	private int resistance_up;

	public Tile() {

	}

	public Tile(int resistance, int resistance_up, int resistance_down) {
		this.resistance = resistance;
		this.resistance_up = resistance_up;
		this.resistance_down = resistance_down;
	}

	/**
	 * Applies the specified amount of toxin to the tile.
	 * 
	 * @param toxin
	 *            The amount of toxin to apply.
	 * @return True if the tile is killed; otherwise, false.
	 */
	protected abstract boolean applyToxin(int toxin);

	protected abstract void discard();

	protected int getResistance() {
		return resistance;
	}

	public boolean isActive() {
		return !dormant;
	}

	public boolean isDormant() {
		return dormant;
	}

	public void reset() {
		turnUp();
		life = resistance;
	}

	protected void turnDown() {
		resistance = resistance_down;
	}

	protected void turnUp() {
		resistance = resistance_up;
	}
}
