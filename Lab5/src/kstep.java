import java.util.Random;

import se.lth.cs.pt.window.SimpleWindow;

public class kstep {

	public static void main(String[] Args) throws InterruptedException {
		SimpleWindow w = new SimpleWindow(600, 600, "1k random steps");
		Random r = new Random();
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();
		for (int i = 0; i < 1000; i++) {
			t.forward(r.nextInt(10) + 1);
			t.left(r.nextInt(181) - r.nextInt(181));
			Thread.sleep(10);
		}
	}
}
