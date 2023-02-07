package edu.hust.tu.projecti;

import edu.hust.tu.projecti.database.History;
import edu.hust.tu.projecti.util.Util;
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
import java.sql.SQLException;

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
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void showHistory() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("History");
        ButtonType type = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        var res = History.userLastPlays(5, ALTPApplication.USER_ID);
        String historyMessage = "";
        try {
            while (res.next()) {
                String temp = "Điểm số: " + res.getString("Score") + " - Thời gian chơi: " + Util.convertTime(res.getString("PlayDate")) + "\n";
                System.out.print(temp);
                historyMessage = historyMessage.concat(temp);
                System.out.println("Diem so" + historyMessage);
            }
        } catch (SQLException ignored) {}
        //Show player history
        dialog.setContentText("Kết quả người chơi: " + "\n"
            + historyMessage
        );
        System.out.println("Ket qua: " + historyMessage);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.show();
    }
}
