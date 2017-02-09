package inputOutputClasses;

import java.io.File;
import java.util.Scanner;

public class SourceChooser {

	public int choose(Scanner input) {
		System.out.println("Dzieñ dobry!");
		System.out.println("Wciœnij 1, aby rêcznie wprowadziæ dane");
		System.out.println("Wciœnij 2, aby wprowdziæ dane z pliku "+FileInputOutput.INPUT_FILE_NAME+" i zapisaæ wyniki w pliku "+FileInputOutput.OUTPUT_FILE_NAME);
		System.out.println("Wciœnij 3, aby otworzyæ wersjê okienkow¹");

		String choosedNumber = "";
		while (true) {
			choosedNumber = input.nextLine();
			switch (choosedNumber) {
			case "1":
				return 1;
			case "2":
				File file = new File(FileInputOutput.INPUT_FILE_NAME);
				if (file.exists()) {
					input.close();
					return 2;
				} else {
					System.out
							.println("Nieodnaleziono pliku, nale¿y dane wprowadziæ rêcznie"
									+ "\n");
					return 1;
				}
			case "3":
				return 3;
			}
		}
	}
}
