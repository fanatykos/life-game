package app;

import inputOutputClasses.InputOutput;
import inputOutputClasses.SourceChooser;
import inputOutputClasses.SourceFactory;

import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controlLife.ControlOfLife;
import data.DataReader;
import data.LifeBoard;

public class LifeMain extends Application {
	public static void main(String[] args) {

		DataReader reader = new DataReader();
		Scanner input = new Scanner(System.in);
		SourceChooser chooser = new SourceChooser();
		SourceFactory sourceFactory = new SourceFactory();
		int selectedChoice = chooser.choose(input);
		InputOutput inOut = null;
		try {
			switch (selectedChoice) {
			case 1:
				inOut = sourceFactory.createSystemInputOutput(input);
				startStandardMethod(inOut, reader);
				break;

			case 2:
				inOut = sourceFactory.createFileInputOutput();
				startStandardMethod(inOut, reader);
				break;

			case 3:
				launch(args);
				break;
			}

		} finally {
			if (inOut != null) {
				inOut.close();
			}
			if (input != null) {
				input.close();
			}
			System.exit(0);
		}
	}

	private static void startStandardMethod(InputOutput inOut, DataReader reader) {
		LifeBoard board = reader.readAndCreateLifeBoard(inOut);
		inOut.printInformationMessage(board);
		ControlOfLife control = new ControlOfLife(inOut);
		control.startLife(board, reader.getNumberOfRounds());
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource(
				"/fxView/MainPane.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("'Life game' by PP");
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
		stage.show();

	}
}
