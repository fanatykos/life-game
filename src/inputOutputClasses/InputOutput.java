package inputOutputClasses;

import data.LifeBoard;

public interface InputOutput {

	static final int MAX_VALUE = 50;
	static final int MAX_ROUND = 10;
	public final static String ERROR_MESSAGE = "Nie poda�e� prawid�owej warto�ci";

	void printFirstMessage();

	void printInformationMessage(LifeBoard board);

	void printLifeBoardAfterRound(LifeBoard board, int roundNumber);

	int readWidth();

	int readHeigh();

	int readNumberOfLiveCells(int maxNumberOfLIveCells);

	int readNumberOfRounds();

	void close();

	

}