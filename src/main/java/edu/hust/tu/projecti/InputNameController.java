package edu.hust.tu.projecti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAKey;
import java.sql.*;
import java.util.ResourceBundle;

public class InputNameController {
    @FXML
    private TextField tfUserName;
    @FXML
    private Button bConfirmName;
    private Stage stage;
    private Scene scene;
    private Parent root = null;
    private String sUserName;
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String dbURL = "jdbc:mysql://localhost:3306/projecti",
            userName= "root",
            password= "";
    @FXML
    protected void onClickConfirmName(ActionEvent event) {
        sUserName = tfUserName.getText();
        String sqlQuery = "INSERT INTO ProjectI.Users " +
                "(Name, Score, `Date`) " +
                "VALUES(?, null, current_timestamp());";

        int userID = 0;
        try {
            connection = DriverManager.getConnection(dbURL,
                    userName,
                    password);
            if (sUserName != "") {
                statement = (PreparedStatement) connection.prepareStatement(sqlQuery);
                statement.setString(1, sUserName);
                userID = statement.executeUpdate();
                if (userID != 0) {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home-view.fxml"));
                        root = loader.load();
                        scene = new Scene(root);
                        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                }
            }
            connection.close();
        }   catch (SQLException e) {
            e.printStackTrace();
        }   catch (Exception e) {
            e.printStackTrace();
        }
        //        statement.executeUpdate();
////        try{
////           connection = DriverManager.getConnection(dbURL,
////                   userName,
////                   password);
////           statement = (PreparedStatement) connection.prepareStatement("Select UID from ProjectI.Users "
////                   + "where ProjectI.Users.Name = ?;");
////           statement.setString(1, sUserName);
////           resultSet = statement.executeQuery();
////           resultSet.next();
////           userID = resultSet.getInt("UID");
////       }    catch (SQLException e)  {}
        // jump to play view
        // use userID to add point after lost

    }

}
