import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private double x;
	private double y;
	private double z;
	private boolean p;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.x = x;
		this.y = y;
		this.w = w;
		
		w.moveTo(x, y);
		p = false;
		z = Math.PI / 2;
	}

	/** Sänker pennan. */
	public void penDown() {
		p = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		p = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo((int)Math.round(x), (int)Math.round(y));
		x = x + n * Math.cos(z);
		y = y - n * Math.sin(z);
		if (p == true) {
			w.lineTo((int) Math.round(x), (int) Math.round(y));
		} else {
			w.moveTo((int) Math.round(x), (int) Math.round(y));
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		z = z + Math.toRadians(beta);
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller
	 * lyft) och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
		w.moveTo((int) Math.round(x), (int) Math.round(y));
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		z = Math.PI / 2;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}

	/**
	 * Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln.
	 */
	public int getDirection() {
		return (int) Math.round(Math.toDegrees(z));
	}
}