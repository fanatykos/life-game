package inputOutputClasses;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import data.LifeBoard;

public class SystemInputOutput implements InputOutput {

	Scanner input;

	public SystemInputOutput(Scanner input) {
		this.input = input;
	}

	@Override
	public void printFirstMessage() {
		System.out.println("Podaj wymiary tablicy �ycia.");
	}

	@Override
	public int readWidth() {
		System.out.println("szeroko�� (powinna mie�ci� si� w granicach 2-"
				+ MAX_VALUE + "): ");
		Boolean condition = true;
		int width = 0;
		while (condition) {
			try {
				width = input.nextInt();
				if (width >= 2 && width <= MAX_VALUE) {
					System.out.println();
					condition = false;
				} else {
					System.out
							.println("szeroko�� tablicy musi by� wi�ksza od 1 i mniejsza lub r�wna "
									+ MAX_VALUE);
				}
			} catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);

			} finally {
				input.nextLine();
			}
		}
		return width;
	}

	@Override
	public int readHeigh() {
		System.out.println("wysoko�� (powinna mie�ci� si� w granicach 2-"
				+ MAX_VALUE + "): ");
		int heigh = 0;
		Boolean condition = true;
		while (condition) {
			try {
				heigh = input.nextInt();
				if (heigh >= 2 && heigh <= MAX_VALUE) {
					System.out.println();
					condition = false;
				} else {
					System.out
							.println("wysoko�c tablicy musi by� wi�ksza od 1 i mniejsza lub r�wna "
									+ MAX_VALUE);
				}

			} catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);
			} finally {
				input.nextLine();
			}

		}
		return heigh;
	}

	@Override
	public int readNumberOfLiveCells(int maxNumberOfLIveCells) {
		System.out
				.println("Podaj liczb� �ywych kom�rek (powinna by� wi�ksza od 0 i nie wi�ksza ni� "
						+ maxNumberOfLIveCells + ":");
		int numberOfLiveCells = 0;
		Boolean condition = true;
		while (condition) {
			try {
				numberOfLiveCells = input.nextInt();
				if (numberOfLiveCells > 0
						&& numberOfLiveCells <= maxNumberOfLIveCells) {
					System.out.println();
					condition = false;
				} else {
					if (numberOfLiveCells <= 0) {
						System.out
								.println("�eby gra mia�a sens, liczba �ywych kom�rek musi by� wi�ksza od 0");
					} else {
						System.out
								.println("liczba �ywych kom�rek nie mo�e przekracza� "
										+ maxNumberOfLIveCells);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);
			} finally {
				input.nextLine();
			}

		}
		return numberOfLiveCells;
	}

	@Override
	public int readNumberOfRounds() {
		System.out
				.println("Podaj liczb� rund �ycia (�eby gra mia�a sens, ilo�� rund powinna by� wi�ksza ni� 0, ale te� mniejsza od "
						+ MAX_ROUND + "):");
		int rounds = 0;
		Boolean condition = true;
		while (condition) {
			try {
				rounds = input.nextInt();
				if (rounds > 0 && rounds <= MAX_ROUND) {
					System.out.println();
					condition = false;
				} else {
					if (rounds <= 0) {
						System.out.println("Gra musi mie� w�cej ni� 0 rund");
					} else {
						System.out.println("Liczba rund nie mo�e przekracza� "
								+ MAX_ROUND);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println(ERROR_MESSAGE);
			} finally {
				input.nextLine();
			}
		}
		return rounds;

	}

	public void close() {
		input.close();
	}

	public void printInformationMessage(LifeBoard board) {
		Date timeNow = new Date();
		System.out.println("Dnia: "
				+ new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(timeNow));
		System.out.println("Stworzono tak� oto tablic� �ycia:");
		printBoard(board);
	}

	public void printLifeBoardAfterRound(LifeBoard board, int roundNumber) {
		System.out.println("Tablica �ycia po " + roundNumber + " rundzie.");
		printBoard(board);
	}

	private void printBoard(LifeBoard board) {
		System.out.println(board.toString());
	}
}