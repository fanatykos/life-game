package controlLife;

import inputOutputClasses.InputOutput;
import data.LifeBoard;

public class ControlOfLife {
	private InputOutput inOut;

	public ControlOfLife(InputOutput inOut) {
		this.inOut = inOut;

	}

	public void startLife(LifeBoard lifeB, int numberOfRounds) {
		for (int i = 0; i < numberOfRounds; i++) {
			int[][] temporaryLifeBoard = new int[lifeB.getHeigh()][lifeB
					.getWidth()];

			for (int heigh = 0; heigh < lifeB.getHeigh(); heigh++) {

				for (int width = 0; width < lifeB.getWidth(); width++) {

					int numberOfLifeNeighbours = checkNeighbours(lifeB, heigh,
							width);

					if (lifeB.getLifeBoard()[heigh][width] == 0) {
						if (numberOfLifeNeighbours == 3) {
							temporaryLifeBoard[heigh][width] = 1;
						} else
							temporaryLifeBoard[heigh][width] = 0;
					}
					if (lifeB.getLifeBoard()[heigh][width] == 1) {
						if (numberOfLifeNeighbours < 2
								|| numberOfLifeNeighbours > 3) {
							temporaryLifeBoard[heigh][width] = 0;

						} else
							temporaryLifeBoard[heigh][width] = 1;
					}

				}
			}
			lifeB.setLifeBoard(temporaryLifeBoard);
			inOut.printLifeBoardAfterRound(lifeB, i + 1);

		}
	}

	private int checkNeighbours(LifeBoard lifeB, int x, int y) {
		int[][] checkLifeB = lifeB.getLifeBoard();
		int liveNeighbours = 0;
		for (int checkX = (x - 1); checkX <= (x + 1); checkX++) {
			for (int checkY = (y - 1); checkY < (y + 2); checkY++) {
				boolean belongsToArray = checkX >= 0
						&& checkX < checkLifeB.length && checkY >= 0
						&& checkY < checkLifeB[0].length;
				if (belongsToArray && checkLifeB[checkX][checkY] == 1
						&& (checkX != x || checkY != y)) {
					liveNeighbours++;

				}

			}
		}
		return liveNeighbours;
	}

}
