package strain.tile;

public class PetriDish extends Tile {

	protected int atpCost;
	
	PetriDish(int atpCost) {
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
}
