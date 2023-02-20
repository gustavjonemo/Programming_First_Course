import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> TurtleList = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> WinList = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();

		for (int n = 1; n < 9; n++) {
			TurtleList.add(new RaceTurtle(w, n));
		}

		while (WinList.size() < 8) {
			for (int n = 0; n < TurtleList.size(); n++) {
				RaceTurtle r = TurtleList.get(n);
				if (r.getX() < RaceWindow.X_END_POS) {
					r.raceStep();
					RaceWindow.delay(2);
				} else {
					WinList.add(r);
					TurtleList.remove(r);
					n--;
				}
			}
		}
		Turtle t1 = WinList.get(0);
		Turtle t2 = WinList.get(1);
		Turtle t3 = WinList.get(2);
		System.out.println("I mål!\nPå första plats: " + t1.toString() + "\nPå andra plats:  " + t2.toString()
				+ "\nPå tredje plats: " + t3.toString());
	}
}
