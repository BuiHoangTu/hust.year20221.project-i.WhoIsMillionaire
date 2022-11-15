package edu.hust.tu.projecti;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ALTPApplication extends Application {
    public static final String dbURL = "jdbc:mysql://localhost:3306/ProjectI",
            userName= "root",
            password= "";
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