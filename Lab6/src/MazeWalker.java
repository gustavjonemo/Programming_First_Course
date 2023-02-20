import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle turtle;

	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}

	public void walk(Maze maze) throws InterruptedException {
		int delay = 0;
		boolean wl = maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY());
		boolean wf = maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY());
		turtle.penDown();
		if (wl == true && wf == false) {
			turtle.forward(1);
			Thread.sleep(delay);
		} else if (wl == true && wf == true) {
			turtle.left(270);
		} else if (wl == false && wf == true) {
			turtle.left(90);
			turtle.forward(1);
			Thread.sleep(delay);
		} else if (wl == false && wf == false) {
			turtle.left(90);
			turtle.forward(1);
			Thread.sleep(delay);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		SimpleWindow w = new SimpleWindow(500, 500, "MazeRunner");
		System.out.print("Svårighetsgrad (1-5): ");
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		if (i > 5) {
			i = 5;
		}
		if (i < 1) {
			i = 1;
		}
		Maze m = new Maze(i);
		m.draw(w);
		Turtle turtle = new Turtle(w, m.getXEntry(), m.getYEntry());
		MazeWalker mw = new MazeWalker(turtle);
		while (m.atExit(turtle.getX(), turtle.getY()) == false) {
			mw.walk(m);
		}
		System.out.println("Done");
	}
}
