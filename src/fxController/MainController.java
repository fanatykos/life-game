package fxController;

import inputOutputClasses.InputOutput;
import inputOutputClasses.WindowInputOutput;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import actionOnSentence.ActionOnSentence;
import controlLife.ControlOfLife;
import data.DataReader;
import data.LifeBoard;

public class MainController implements Initializable {

	@FXML
	private TextField heighValue;

	@FXML
	private TextField widthValue;

	@FXML
	private TextField numberOfLIveCells;

	@FXML
	private TextField numberOfRounds;

	@FXML
	private TextArea displayField;

	@FXML
	Button startButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		startButton.setDisable(true);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				ActionOnSentence aOS = new ActionOnSentence();
				guardEnteredValue(heighValue, aOS);
				guardEnteredValue(widthValue, aOS);
				guardEnteredValue(numberOfLIveCells, aOS);
				guardEnteredValue(numberOfRounds, aOS);
			}
		});

		startButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						startButton.setDisable(true);
						calculateLifeBoardInWindow();
						startButton.setDisable(false);
					}
				}).start();
			}
		});
	}

	private void calculateLifeBoardInWindow() {
		DataReader reader = new DataReader();
		InputOutput inOut = new WindowInputOutput(MainController.this);
		LifeBoard board = reader.readAndCreateLifeBoard(inOut);
		inOut.printInformationMessage(board);
		ControlOfLife control = new ControlOfLife(inOut);
		control.startLife(board, reader.getNumberOfRounds());
	}

	private void guardEnteredValue(TextField textArea, ActionOnSentence aOS) {
		textArea.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				textArea.setText(aOS.removeOtherChars(newValue));
				checkValuesToEnableStartButton();
			}
		});
	}

	private void checkValuesToEnableStartButton() {
		if (heighValue.getText() != "" && widthValue.getText() != ""
				&& numberOfLIveCells.getText() != ""
				&& numberOfRounds.getText() != "") {
			if (Integer.parseInt(heighValue.getText()) >= 2
					&& Integer.parseInt(heighValue.getText()) <= InputOutput.MAX_VALUE
					&& Integer.parseInt(widthValue.getText()) >= 2
					&& Integer.parseInt(widthValue.getText()) <= InputOutput.MAX_VALUE
					&& Integer.parseInt(numberOfLIveCells.getText()) >= 0
					&& Integer.parseInt(numberOfLIveCells.getText()) <= (Integer
							.parseInt(heighValue.getText()) * Integer
							.parseInt(widthValue.getText()))
					&& Integer.parseInt(numberOfRounds.getText()) >= 1
					&& Integer.parseInt(numberOfRounds.getText()) <= InputOutput.MAX_ROUND) {
				displayField.setText("Wprowadzone dane s¹ prawid³owe, klinij przycisk 'START'");
				startButton.setDisable(false);
			} else {
				displayField
						.setText("Podane przez Ciebie wartoœci nie mieszcz¹ siê w dopuszczalnych przedzia³ach."
								+ "\n"
								+ "Wysokoœæ musi mieœciæ siê w zakresie: 2 do "
								+ InputOutput.MAX_VALUE
								+ "\n"
								+ "Szerokoœæ musi mieœciæ siê w zakresie: 2 do "
								+ InputOutput.MAX_VALUE
								+ "\n"
								+ "Liczba ¿ywych komórek nie mo¿e przekraczaæ iloczynu: wyokoœc x szerokoœc"
								+ "\n"
								+ "Liczba rund musi mieœciæ siê w zakresie: 1 do "
								+ InputOutput.MAX_ROUND);
				startButton.setDisable(true);
			}
		}
	}

	public TextField getHeighValue() {
		return heighValue;
	}

	public TextField getWidthValue() {
		return widthValue;
	}

	public TextField getNumberOfLIveCells() {
		return numberOfLIveCells;
	}

	public TextField getNumberOfRounds() {
		return numberOfRounds;
	}

	public TextArea getDisplayField() {
		return displayField;
	}

}
