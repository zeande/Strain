package strain.tile;

public class PetriDish extends Tile {

	protected int atpCost;

	public PetriDish(String name,int atpCost,int resistance_up, int resistance_down) {
		super(name,resistance_up, resistance_up, resistance_down);
		this.atpCost = atpCost;
	}

	@Override
	protected boolean applyToxin(int toxin) {
		life -= toxin;
		return life <= 0;
	}

	@Override
	protected void discard() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		String tileString = "************\n";
		tileString +=       "*          *\n";
		tileString +=       "* " + (name + "       ").substring(0,8) + " *\n";
		tileString +=       "*          *\n";
		tileString +=       "*          *\n";
		tileString +=       "*    " + resistance + "     *\n";
		tileString +=       "************\n";
		
		return tileString;
	}
}
