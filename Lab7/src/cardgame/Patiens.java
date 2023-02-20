package cardgame;

import pair.Pair;
import pair.PairSet;

public class Patiens {
	private static final double repeat = Math.pow(10, 7);

	public static void main(String[] Args) {
		double win = 0;

		for (int i = 0; i < repeat; i++) {
			boolean b = true;
			PairSet d = new PairSet(4, 13);
			for (int c = 0; c < 3 && d.more() == true; c++) {
				Pair p = d.pick();
				if (p.second() == c) {
					b = false;
					c = 3;
				} else if (c == 2) {
					c = -1;
				}
			}
			if (b == true) {
				win++;
			}
		}
		double success = (win/repeat)*100;
		System.out.println("Successrate = " + success + "%");
	}
}
