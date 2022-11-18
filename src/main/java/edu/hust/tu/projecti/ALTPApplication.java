package edu.hust.tu.projecti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ALTPApplication extends Application {
    /**
     * Database connect properties
     * @deprecated
     * These properties are no longer recommended to establish
     * connection to database. They would become private in
     * future version.
     * <p> Use {@link package.class#getConnection()} instead
     */
    @Deprecated
    public static final String dbURL = "jdbc:mysql://localhost:3306/ProjectI",
            userName= "root",
            password= "";
    private static volatile Connection connection = null;
        public Connection getConnection(){
            if(connection == null){
                try{
                    connection = DriverManager.getConnection(
                            dbURL,
                            userName,
                            password
                    );
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            return connection;
        }

    @Override
    public void start(Stage stage){
        FXMLLoader fxmlLoader = new FXMLLoader(ALTPApplication.class.getResource("InputName-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Image icon = new Image(" "); /*path to icon */

        stage.setTitle("Ai là Triệu phú");
        //stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}