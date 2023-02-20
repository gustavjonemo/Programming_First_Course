import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> TurtleList = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> WinList = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		Random rand = new Random();

		for (int n = 1; n < 9; n++) {
			
			switch (rand.nextInt(3)) {
			case 0:
				TurtleList.add(new MoleTurtle(w, n));
				break;

			case 1:
				TurtleList.add(new AbsentMindedTurtle(w, n, rand.nextInt(101)));
				break;

			case 2:
				TurtleList.add(new DizzyTurtle(w, n, rand.nextInt(5)+1));
				break;
			}
		}
		for (int n = 0; n < 8; n++) {
		System.out.println(TurtleList.get(n).toString());
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
		System.out.println("I mål!\nPå första plats: " + WinList.get(0).toString() + "\nPå andra plats:  " + WinList.get(1).toString()
				+ "\nPå tredje plats: " + WinList.get(2).toString());
	}
}
