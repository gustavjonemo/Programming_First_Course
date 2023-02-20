import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		w.moveTo(0, 0);
		w.waitForMouseClick();
		w.moveTo(w.getMouseX(), w.getMouseY());
		while (true) {
			w.waitForMouseClick();
			w.setLineColor(Color.ORANGE);
			w.lineTo(w.getMouseX(), w.getMouseY());
			int x = w.getMouseX();
			int y = w.getMouseY();
			w.writeText("Det där");
			w.waitForMouseClick();
			w.setLineColor(Color.BLACK);
			w.setLineWidth(5);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.moveTo(x, y);
			w.setLineColor(Color.WHITE);
			w.setLineWidth(3);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.setLineColor(Color.BLACK);
			w.writeText("det gjorde du");
			w.setLineWidth(1);
			w.waitForMouseClick();
			w.setLineColor(Color.RED);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("fan så bra");
			w.waitForMouseClick();
			w.setLineColor(Color.BLUE);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("hej!");
			w.waitForMouseClick();
			w.setLineColor(Color.MAGENTA);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("En skål uti botten");
			w.waitForMouseClick();
			w.setLineColor(Color.YELLOW);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("för dig");
			w.waitForMouseClick();
			w.setLineColor(Color.PINK);
			w.lineTo(w.getMouseX(), w.getMouseY());
			w.writeText("nu jag ta!");
		}
	}
}