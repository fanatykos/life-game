package inputOutputClasses;

import java.io.File;
import java.util.Scanner;

public class SourceChooser {

	public int choose(Scanner input) {
		System.out.println("Dzie� dobry!");
		System.out.println("Wci�nij 1, aby r�cznie wprowadzi� dane");
		System.out.println("Wci�nij 2, aby wprowdzi� dane z pliku "+FileInputOutput.INPUT_FILE_NAME+" i zapisa� wyniki w pliku "+FileInputOutput.OUTPUT_FILE_NAME);
		System.out.println("Wci�nij 3, aby otworzy� wersj� okienkow�");

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
							.println("Nieodnaleziono pliku, nale�y dane wprowadzi� r�cznie"
									+ "\n");
					return 1;
				}
			case "3":
				return 3;
			}
		}
	}
}
