import java.awt.Color;
import java.util.Random;

import se.lth.cs.pt.square.Square;
import se.lth.cs.pt.window.SimpleWindow;

public class pspace {

	public static void main(String[] Args) throws InterruptedException {
		SimpleWindow w = new SimpleWindow(600, 600, "Don't touch me");
		Random r = new Random();
		Turtle t1 = new Turtle(w, w.getWidth()/2 - 50, w.getHeight()/2 - 50);
		Turtle t2 = new Turtle(w, w.getWidth()/2 + 50, w.getHeight()/2 + 50);
		t1.penDown();
		t2.penDown();
		for (double d = Math.hypot((t1.getX() - t2.getX()), (t1.getY() - t2.getY())); d > 50; d = Math
				.hypot((t1.getX() - t2.getX()), (t1.getY() - t2.getY()))) {
			t1.forward(r.nextInt(10) + 1);
			t1.left(r.nextInt(181) - r.nextInt(181));
			t2.forward(r.nextInt(10) + 1);
			t2.left(r.nextInt(181) - r.nextInt(181));
			

			if (t1.getX() < 0) {
				t1.jumpTo(w.getWidth(), t1.getY());
			} else if (t1.getX() > w.getWidth()) {
				t1.jumpTo(0, t1.getY());
			}
			if (t1.getY() < 0) {
				t1.jumpTo(t1.getX(), w.getHeight());
			} else if (t1.getY() > w.getHeight()) {
				t1.jumpTo(t1.getX(), 0);
			}

			if (t2.getX() < 0) {
				t2.jumpTo(w.getWidth(), t2.getY());
			} else if (t2.getX() > w.getWidth()) {
				t2.jumpTo(0, t2.getY());
			}
			if (t2.getY() < 0) {
				t2.jumpTo(t2.getX(), w.getHeight());
			} else if (t2.getY() > w.getHeight()) {
				t2.jumpTo(t2.getX(), 0);
			}
			SimpleWindow.delay(10);
		}
		w.setLineColor(Color.RED);
		w.setLineWidth(3);
		Square sq1 = new Square(t1.getX()-15, t1.getY()-15, 30);
		sq1.draw(w);
		Square sq2 = new Square(t2.getX()-15, t2.getY()-15, 30);
		sq2.draw(w);
		w.setLineColor(Color.ORANGE);
		w.setLineWidth(2);
		Square sq3 = new Square(t1.getX()-1, t1.getY()-1, 3);
		sq3.draw(w);
		Square sq4 = new Square(t2.getX()-1, t2.getY()-1, 3);
		sq4.draw(w);
	}
}