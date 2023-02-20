import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;
	/**
	 * Skapar en sköldpadda som ska springa i fönstret w och som har start*
	 * nummer nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	 */
	RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		penDown();
		left(270);
	}

	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett slumptal
	 * (heltal) mellan 1 och 6.
	 */
	void raceStep() {
		Random rand = new Random();
		forward(rand.nextInt(6) + 1);
	}

	/**
	 * Returnerar en läsbar representation av denna RaceTurtle, på formen
	 * "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString() {
		return "Nummer " + nbr;
	}
}
