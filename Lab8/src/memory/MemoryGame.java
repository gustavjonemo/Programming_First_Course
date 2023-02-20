package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		MemoryBoard mb = new MemoryBoard(4, "back.jpg", frontFileNames);
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