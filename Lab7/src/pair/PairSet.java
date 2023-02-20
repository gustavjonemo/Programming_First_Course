package pair;

import java.util.Random;

public class PairSet {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();

	/**
	 * Skapar en mängd av alla talpar (a,b) sådana att 0 <= a < rows och 0 <= b
	 * < cols
	 */

	public PairSet(int rows, int cols) {
		n = rows * cols;
		pairs = new Pair[n];
		int k = 0;
		for (int b = 0; b < cols; b++) {
			for (int a = 0; a < rows; a++) {
				pairs[k] = new Pair(a, b);
				k++;
			}
		}
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		if (n < 1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Hämtar ett slumpmässigt valt talpar ur mängden. Mängden blir ett element
	 * mindre. Om mängden är tom returneras null.
	 */
	public Pair pick() {
		if (more()) {
			int i = 0;
			i = rand.nextInt(n);
			Pair p = pairs[i];
			pairs[i] = pairs[n-1];
			n--;
			return p;
		} else {
			return null;
		}
	}
}
