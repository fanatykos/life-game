package data;

import inputOutputClasses.InputOutput;

public class DataReader {

	private LifeBoard lifeB;
	private int numberOfRounds;

	public DataReader() {
	}

	public LifeBoard readAndCreateLifeBoard(InputOutput inOut) {
		inOut.printFirstMessage();
		int width = inOut.readWidth();
		int heigh = inOut.readHeigh();
		int numberOfLiveCells = inOut.readNumberOfLiveCells(width * heigh);
		int rounds = inOut.readNumberOfRounds();
		setNumberOfRounds(rounds);
		this.lifeB = new LifeBoard(heigh, width, numberOfLiveCells);
		setLifeB(lifeB);
		return lifeB;
	}

	public int getNumberOfRounds() {
		return numberOfRounds;
	}

	public void setNumberOfRounds(int numberOfRounds) {
		this.numberOfRounds = numberOfRounds;
	}

	public LifeBoard getLifeB() {
		return lifeB;
	}

	public void setLifeB(LifeBoard lifeB) {
		this.lifeB = lifeB;
	}
}
