package inputOutputClasses;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import data.LifeBoard;

public class FileInputOutput implements InputOutput {
	final static String INPUT_FILE_NAME = "inputFile.txt";
	final static String OUTPUT_FILE_NAME = "outputFile.txt";

	BufferedReader input;
	BufferedWriter writer;

	public FileInputOutput() {
		try {
			this.input = new BufferedReader(new FileReader(INPUT_FILE_NAME));
		} catch (FileNotFoundException e) {
			System.out.println("Plik z danymi wejœciowymi nie istnieje");
			try {
				input.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		try {
			this.writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME,
					true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void printFirstMessage() {
		System.out.println("Odczytano dane z pliku " + INPUT_FILE_NAME);
		System.out.println();

	}

	@Override
	public int readWidth() {
		int width;
		try {
			width = Integer.parseInt(input.readLine());
			if (width > MAX_VALUE || width < 2) {
				System.out
						.println("Wartoœæ wysokoœci niedopuszczalna, wysokoœæ zostanie losowo przypisana");
				width = randomValue(MAX_VALUE);
			}

		} catch (IOException e) {
			System.out
					.println("B³¹d odczytu, wyosokoœæ zostanie losowo przypisana");
			width = randomValue(MAX_VALUE);
		}
		return width;
	}

	@Override
	public int readHeigh() {
		int heigh;
		try {
			heigh = Integer.parseInt(input.readLine());
			if (heigh > MAX_VALUE || heigh < 2) {
				System.out
						.println("Wartoœæ szerokoœci niedopuszczalna, wysokoœæ zostanie losowo przypisana");
				heigh = randomValue(MAX_VALUE);
			}

		} catch (IOException e) {
			System.out
					.println("B³¹d odczytu, szerokoœæ zostanie losowo przypisana");
			heigh = randomValue(MAX_VALUE);
		}
		return heigh;
	}

	@Override
	public int readNumberOfLiveCells(int maxNumberOfLIveCells) {
		int numberOfLiveCells;
		try {
			numberOfLiveCells = Integer.parseInt(input.readLine());
			if (numberOfLiveCells > maxNumberOfLIveCells
					|| numberOfLiveCells < 2) {
				System.out
						.println("Liczba ¿ywych komórek niedopuszczalna, zostanie losowo przypisana");
				numberOfLiveCells = randomValue(maxNumberOfLIveCells);
			}

		} catch (IOException e) {
			System.out
					.println("B³¹d odczytu, liczba ¿ywych komórek zostanie losowo przypisana");
			numberOfLiveCells = randomValue(maxNumberOfLIveCells);
		}
		return numberOfLiveCells;
	}

	@Override
	public int readNumberOfRounds() {
		int numberOfRounds;
		try {
			numberOfRounds = Integer.parseInt(input.readLine());
			if (numberOfRounds > MAX_ROUND || numberOfRounds < 2) {
				System.out
						.println("Liczba rund niedopuszczalna, zostanie losowo przypisana");
				numberOfRounds = randomValue(MAX_ROUND);
			}

		} catch (IOException e) {
			System.out
					.println("B³¹d odczytu, szerokoœæ zostanie losowo przypisana");
			numberOfRounds = randomValue(MAX_VALUE);
		}
		return numberOfRounds;
	}

	public void close() {
		try {
			input.close();
			writer.close();
			System.out.println("Zapisano dane do pliku " + OUTPUT_FILE_NAME);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int randomValue(int maxValue) {
		Random random = new Random();
		int randomValue = random.nextInt(maxValue);
		return randomValue;
	}

	public void printInformationMessage(LifeBoard board) {
		Date timeNow = new Date();
		try {
			writer.write("Dnia: "
					+ new SimpleDateFormat("yyyy:MM:dd HH:mm:ss")
							.format(timeNow));
			writer.newLine();
			writer.write("Stworzono tak¹ oto tablicê ¿ycia:");
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		writeBoard(board);
	}

	public void printLifeBoardAfterRound(LifeBoard board, int roundNumber) {
		try {
			writer.write("Tablica ¿ycia po " + roundNumber + " rundzie.");
			writer.newLine();
		} catch (IOException e) {

			e.printStackTrace();
		}
		writeBoard(board);
	}

	private void writeBoard(LifeBoard board) {
		String result = "";
		for (int i = 0; i < board.getHeigh(); i++) {
			for (int j = 0; j < board.getWidth(); j++) {
				result += board.getLifeBoard()[i][j] + " ";
			}
			try {
				writer.write(result);
				writer.newLine();
				result = "";
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
