package inputOutputClasses;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;

import data.LifeBoard;
import fxController.MainController;

public class WindowInputOutput implements InputOutput {
	MainController mainController;

	public WindowInputOutput(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void printFirstMessage() {
		mainController.getDisplayField().setText(
				"Hi! Life Game is calculating!");
		waitTwoSeconds();
	}

	@Override
	public void printInformationMessage(LifeBoard board) {
		Date timeNow = new Date();
		StringBuilder string = new StringBuilder();
		string.append("Dnia: "
				+ new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(timeNow)
				+ ". Stworzono tak¹ oto tablicê ¿ycia:" + "\n" + "\n");
		string.append(printBoard(board));
		mainController.getDisplayField().clear();
		mainController.getDisplayField().setText(string.toString());
	}

	@Override
	public void printLifeBoardAfterRound(LifeBoard board, int roundNumber) {
		waitTwoSeconds();
		StringBuilder string = new StringBuilder();
		string.append("Tablica ¿ycia po " + roundNumber + " rundzie." + "\n"
				+ "\n");
		string.append(printBoard(board));
		mainController.getDisplayField().clear();
		mainController.getDisplayField().setText(string.toString());
	}

	private void waitTwoSeconds() {
		LocalTime timeNow = LocalTime.now();
		boolean condition = true;
		while (condition) {
			if (LocalTime.now().isAfter(timeNow.plusSeconds(2))) {
				condition = false;
			}
		}
	}

	private StringBuilder printBoard(LifeBoard board) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < board.getHeigh(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				result.append(board.getLifeBoard()[i][j] + " ");
			}
			result.append("\n");
		}
		return result;
	}

	@Override
	public int readWidth() {
		int width = 0;
		try {
			width = Integer.parseInt(mainController.getWidthValue().getText());
		} catch (NoSuchElementException | NumberFormatException e) {
			width = randomValue(MAX_VALUE);
		}
		return width;
	}

	@Override
	public int readHeigh() {
		int heigh = 0;
		try {
			heigh = Integer.parseInt(mainController.getHeighValue().getText());
		} catch (NoSuchElementException | NumberFormatException e) {
			heigh = randomValue(MAX_VALUE);
		}

		return heigh;
	}

	@Override
	public int readNumberOfLiveCells(int maxNumberOfLIveCells) {
		int numberOfLiveCells = 0;
		try {
			numberOfLiveCells = Integer.parseInt(mainController
					.getNumberOfLIveCells().getText());
		} catch (NoSuchElementException | NumberFormatException e) {
			numberOfLiveCells = randomValue(maxNumberOfLIveCells);

		}
		return numberOfLiveCells;
	}

	@Override
	public int readNumberOfRounds() {
		int numberOfRounds = 0;
		try {
			numberOfRounds = Integer.parseInt(mainController
					.getNumberOfRounds().getText());
		} catch (NoSuchElementException | NumberFormatException e) {
			numberOfRounds = randomValue(MAX_ROUND);
		}
		return numberOfRounds;
	}

	private int randomValue(int maxValue) {
		Random random = new Random();
		int randomValue = random.nextInt(maxValue);
		return randomValue;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
}
