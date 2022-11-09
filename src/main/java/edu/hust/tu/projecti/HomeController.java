package edu.hust.tu.projecti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Play-view.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showHistory(ActionEvent event) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle("History");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        //Show player history
        dialog.setContentText("Kết quả người chơi");
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.show();
    }
}
