import java.util.Random;

public class MoleTurtle extends RaceTurtle {

	MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	void raceStep() {
		Random rand = new Random();
		int r = rand.nextInt(3);
		if(r<2){
			super.penDown();
		} else {
			super.penUp();
		}
		super.raceStep();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" - MoleTurtle");
		return sb.toString();
		
	}
}
