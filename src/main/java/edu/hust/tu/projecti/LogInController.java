package edu.hust.tu.projecti;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogInController {
    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPasswd;
    @FXML
    private Label lWarning;

    private int userID;

    public LogInController() {
    }

    @FXML
    protected void onClickConfirmLogin() {
        String sUserName = tfUserName.getText();
        String sPasswd = tfPasswd.getText();

        Connection connection = ALTPApplication.getConnection();
        PreparedStatement statement;
        try{
            statement = connection.prepareStatement("Select UID from Users "
                    + "where Users.Name = ? and Users.Passwd = ?");
            statement.setString(1, sUserName);
            statement.setString(2, sPasswd);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                userID = resultSet.getInt("UID");

                // change view
                FXMLLoader fxmlLoader = new FXMLLoader(LogInController.class.getResource("Home-view.fxml"));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage =  (Stage) tfUserName.getScene().getWindow();

                stage.setScene(scene);
                stage.show();
            } else {
                lWarning.setVisible(true);
            }

        }catch (SQLException e) {

        }
    }

    public int getUserID() {return userID;}

    @FXML
    protected void onClickToSignup() {
        // change view
        FXMLLoader fxmlLoader = new FXMLLoader(LogInController.class.getResource("SignUp-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage =  (Stage) tfUserName.getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}
