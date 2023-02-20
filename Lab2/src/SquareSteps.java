import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class SquareSteps {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "SquareSteps");
		Square sq = new Square(0, 0, 100);
		sq.draw(w);
		int oldX = 0;
		int oldY = 0;
		while (true) {
			w.waitForMouseClick();
			int x = w.getMouseX();
			int y = w.getMouseY();
			w.moveTo(x, y);
			int xDist = x - oldX;
			int yDist = y - oldY;
			int a = 1;
			int step = 10;
			while (a <= step) {
				sq.move((xDist / step), (yDist / step));
				sq.draw(w);
				oldX = x;
				oldY = y;
				a = a + 1;
			}
		}
	}
}