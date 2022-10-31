package edu.hust.tu.projecti;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.security.interfaces.RSAKey;
import java.sql.*;

public class InputNameController {
    @FXML
    private TextField tfUserName;
    private String sUserName;
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String dbURL = "jdbc:mysql://localhost:3306/",
            userName= "root",
            password= "";
    @FXML
    protected void onClickConfirmName() {
        sUserName = tfUserName.getText();
        String sqlQuery = "INSERT INTO ProjectI.Users " +
                "(Name, Score, `Date`) " +
                "VALUES(?, null, current_timestamp());";

        int userID = 0;
        try{
            connection = DriverManager.getConnection(dbURL,
                    userName,
                    password);
            statement = (PreparedStatement) connection.prepareStatement(sqlQuery);
            statement.setString(1, sUserName);
            userID = statement.executeUpdate();

        }catch (SQLException e) {}

       try{
           connection = DriverManager.getConnection(dbURL,
                   userName,
                   password);
           statement = (PreparedStatement) connection.prepareStatement("Select UID from ProjectI.Users "
                   + "where Name = ?;");
           statement.setString(1, sUserName);
           resultSet = statement.executeQuery();
           userID = resultSet.getInt(1);
       }catch (SQLException e){}

        System.out.println(userID);


    }
}
