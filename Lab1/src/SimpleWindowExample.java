import se.lth.cs.pt.window.SimpleWindow;
import java.awt.Color;

public class SimpleWindowExample {
	public static void main(String[] args){
		SimpleWindow w = new SimpleWindow(500, 500, "Wind_O");
		int x, y;
		x = 150;
		y = 300;
		w.moveTo(x, y);
		w.setLineColor(Color.YELLOW);
		w.setLineWidth(3);
		w.lineTo(x + 100, y - 200);
		w.lineTo(x + 200, y);
		w.lineTo(x - 20, y - 140);
		w.lineTo(x + 220 , y - 140);
		w.lineTo(x, y);
		w.moveTo(x + 70, y - 100);
		w.writeText("Guldstjärna");
	}
}