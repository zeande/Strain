package strain.tile;

import strain.exception.TileNotActiveException;

public class Cytoplasm extends Tile {

	private int atp;
	private int toxin;

	public Cytoplasm(String name, int atp, int toxin, int resistance) {
		super(name, resistance, resistance, 1);
		this.atp = atp;
		this.toxin = toxin;
		this.name = name;
	}

	@Override
	protected boolean applyToxin(int toxin) {
		this.life -= toxin;
		return this.life < 1;
	}

	@Override
	protected void discard() {

	}

	public int getAvailableATP() {
		return isDormant() ? 0 : atp;
	}

	public int getAvailableToxin() {
		return isDormant() ? 0 : toxin;
	}

	public int useATP() throws TileNotActiveException {
		if (isDormant())
			throw new TileNotActiveException("Dormant tiles cannot be used!");
		return atp;
	}

	/**
	 * Uses the cytoplasm's toxin.
	 * 
	 * @return
	 * @throws TileNotActiveException
	 */
	public int useToxin() throws TileNotActiveException {
		if (isDormant())
			throw new TileNotActiveException("Dormant tiles cannot be used!");
		return toxin;
	}

	@Override
	public String toString() {
		String tileString = "*************\n";
		tileString +=       "* Cytoplasm *\n";
		tileString +=       "* " + (name + "       ").substring(0,9) + " *\n";
		tileString +=       "*           *\n";
		tileString +=       "*           *\n";
		tileString +=       "*    " + resistance + "      *\n";
		tileString +=       "*************\n";
		
		return tileString;
	}
}
