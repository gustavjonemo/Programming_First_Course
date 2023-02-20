package memory;

import java.util.Random;

public class MemoryBoard {
	private int size;
	// private String backFileName;
	// private String[] frontFileNames;
	private MemoryCardImage[][] Board;
	private boolean[][] up;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet
	 * för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen
	 * för frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		// this.backFileName = backFileName;
		// this.frontFileNames = frontFileNames;
		this.Board = new MemoryCardImage[size][size];
		up = new boolean[size][size];
		createCards(backFileName, frontFileNames);
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		for (int i = 0; i < (size * size) / 2; i++) {
			MemoryCardImage img = new MemoryCardImage(frontFileNames[i], backFileName);
			int n = 0;
			while (n < 2) {
				int r1 = rand.nextInt(size), r2 = rand.nextInt(size);
				if (Board[r1][r2] == null) {
					Board[r1][r2] = img;
					n++;
				}
			}
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return Board[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (up[r][c] == false) {
			up[r][c] = true;
		} else {
			up[r][c] = false;
		}
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return up[r][c];
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		if (Board[r1][c1] == Board[r2][c2]) {
			return true;
		} else {
			return false;
		}
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int a = 0; a < size; a++) {
			for (int b = 0; b < size; b++) {
				if (up[a][b] == false) {
					return false;
				}
			}
		}
		return true;
	}
}
