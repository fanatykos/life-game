package data;

import java.util.Random;

public class LifeBoard {
	private int heigh;
	private int width;
	private int numberOfLiveCells;
	private int[][] lifeBoard;

	public LifeBoard() {
	}

	public LifeBoard(int heigh, int width, int numberOfLiveCells) {
		this.heigh = heigh;
		this.width = width;
		this.numberOfLiveCells = numberOfLiveCells;
		createLifeBoard();
	}

	private void createLifeBoard() {
		int[][] lifeBoa = new int[getHeigh()][getWidth()];
		for (int i = 0; i < getNumberOfLiveCells(); i++) {
			Random r = new Random();
			int a = r.nextInt(getHeigh());
			int b = r.nextInt(getWidth());
			if (lifeBoa[a][b] == 1) {
				i = i - 1;
			} else {
				lifeBoa[a][b] = 1;
			}

		}
		setLifeBoard(lifeBoa);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getHeigh(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				result.append(getLifeBoard()[i][j] + " ");

			}
			result.append("\n");
		}
		return result.toString();
	}

	public int getHeigh() {
		return heigh;
	}

	public int getWidth() {
		return width;
	}

	public int getNumberOfLiveCells() {
		return numberOfLiveCells;
	}

	public int[][] getLifeBoard() {
		return lifeBoard;
	}

	public void setLifeBoard(int[][] lifeBoard) {
		this.lifeBoard = lifeBoard;
	}
}
