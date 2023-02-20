import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	private int absent;

	AbsentMindedTurtle(RaceWindow w, int nbr, int absent) {
		super(w, nbr);
		this.absent = absent;
	}

	void raceStep() {
		Random rand = new Random();
		int r = rand.nextInt(100) + 1;
		if (absent >= r) {
			super.raceStep();
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" - AbsentMindedTurtle (");
		sb.append(absent);
		sb.append("% Frånvarande)");
		return sb.toString();
	}
}
