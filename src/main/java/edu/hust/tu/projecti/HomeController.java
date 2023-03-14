package edu.hust.tu.projecti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    Button exitButton;

    public void onClickExit() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void switchPlayView(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Play-view.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showHistory() {
		FXMLLoader loader = new FXMLLoader(ALTPApplication.class.getResource("/edu/hust/tu/projecti/History-view.fxml"));
		try {
			Dialog<String> dialog = new Dialog<>();
			DialogPane pane = loader.load();
			dialog.setDialogPane(pane);

			dialog.setTitle("History");

			dialog.show();
		} catch (IOException ignored) {}
    }
}
