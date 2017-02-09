package inputOutputClasses;

import java.util.Scanner;

public class SourceFactory {

	public InputOutput createSystemInputOutput(Scanner input) {
		return new SystemInputOutput(input);
	}

	public InputOutput createFileInputOutput() {
		return new FileInputOutput();
	}

}
