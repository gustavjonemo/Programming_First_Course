import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int yrsel;

	DizzyTurtle(RaceWindow w, int nbr, int yrsel) {
		super(w, nbr);
		this.yrsel = yrsel;
	}

	void raceStep() {
		Random rand = new Random();
		super.turnNorth();
		left(270);
		int a = rand.nextInt(yrsel * 36) - yrsel * 18;
		left(a);
		super.raceStep();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" - DizzyTurtle (Yrsel: ");
		sb.append(yrsel);
		sb.append(")");
		return sb.toString();
	}
}
