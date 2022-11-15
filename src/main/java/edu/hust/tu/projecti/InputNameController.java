package edu.hust.tu.projecti;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class InputNameController {
    @FXML
    private TextField tfUserName;
    private int userID;

    public InputNameController() {
    }

    @FXML
    protected void onClickConfirmName() {
        String sUserName = tfUserName.getText();
        String sqlQuery = "INSERT INTO ProjectI.Users " +
                "(Name, Score, `Date`) " +
                "VALUES(?, null, current_timestamp());";

        //int userID = 0;
        Connection connection = null;
        PreparedStatement statement;
        try{
            connection = DriverManager.getConnection(ALTPApplication.dbURL,
                    ALTPApplication.userName,
                    ALTPApplication.password);
            statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, sUserName);
            statement.executeUpdate();

            statement = connection.prepareStatement("Select UID from ProjectI.Users "
                    + "where ProjectI.Users.Name = ?;");
            statement.setString(1, sUserName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            userID = resultSet.getInt("UID");
        }catch (SQLException e) {}

        //System.out.println(userID);



        // change view
        FXMLLoader fxmlLoader = new FXMLLoader(InputNameController.class.getResource("Home-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage =  (Stage) tfUserName.getScene().getWindow();

        stage.setScene(scene);
        stage.show();

        try {
            connection.close();
        }
        catch (SQLException e){}
    }

    public int getUserID() {return userID;}

}
