package memory;

public class SkalmanMemory {
	public static void main(String[] args) {
		String[] frontFileNames = { "1.jpg", "2.jpg", "3.jpg", "4.jpg",
				"5.jpg", "6.jpg", "7.jpg", "8.jpg" };

		MemoryBoard mb = new MemoryBoard(4, "rygg.jpg", frontFileNames);
		MemoryWindow mw = new MemoryWindow(mb);
		mw.drawBoard();
		int attempts = 0;
		while (mb.hasWon() == false) {
			int a = 0, b = 0, x = 0, y = 0, i = 0;
			while (i < 2) {
				a = x;
				b = y;
				mw.waitForMouseClick();
				x = mw.getMouseRow();
				y = mw.getMouseCol();
				if (mb.frontUp(x, y) == false) {
					mb.turnCard(x, y);
					mw.drawCard(x, y);
					i++;
				}
			}
			if(mb.same(a, b, x, y) == false){
				MemoryWindow.delay(1200);
				mb.turnCard(x, y);
				mw.drawCard(x, y);
				mb.turnCard(a, b);
				mw.drawCard(a, b);
			}
			attempts++;
		}
		System.out.println("Attempts: " + attempts);
	}
}