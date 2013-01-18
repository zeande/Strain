package strain.tile;

public class Cytoplasm extends Tile {

	private int atp;
	private int toxin;
	
	public Cytoplasm(String name, int atp, int toxin, int resistance) {
		super(resistance, resistance,1);
		this.atp = atp;
		this.toxin = toxin;
		this.name = name;
	}
	
	@Override
	protected boolean applyToxin(int toxin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void discard() {
		// TODO Auto-generated method stub

	}

}
