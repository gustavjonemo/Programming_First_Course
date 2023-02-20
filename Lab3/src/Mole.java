public class Mole {
	private Graphics g = new Graphics(40, 70, 8);

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 0, g.getWidth() * g.getBlockSize(), g.getHeight() * g.getBlockSize(), Colors.SOIL);
	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;

		while (true) {
			if(x > g.getWidth()){
				x=0;
			}
			else if(x < 0){
				x=g.getWidth();
			}
			else if (y > g.getHeight()){
				y = 0;
			}
			else if (y < 0){
				y = g.getWidth();
			}
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			g.block(x, y, Colors.TUNNEL);
			if (key == 'w') {
				y = y - 1;
				g.block(x, y, Colors.MOLE);
			} else if (key == 'a') {
				x = x - 1;
				g.block(x, y, Colors.MOLE);
			} else if (key == 's') {
				y = y + 1;
				g.block(x, y, Colors.MOLE);
			} else if (key == 'd') {
				x = x + 1;
				g.block(x, y, Colors.MOLE);
			}
		}
	}
}