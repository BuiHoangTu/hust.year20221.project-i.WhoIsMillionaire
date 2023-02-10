package edu.hust.tu.projecti;

import edu.hust.tu.projecti.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LogInController {
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField tfPasswd;
    @FXML
    private Label lWarning;

	public LogInController() {
    }

    @FXML
    protected void onClickConfirmLogin() {
        String sUserName = tfUserName.getText();
        String sPasswd = tfPasswd.getText();

        try {
			Integer uID = UserService.login(sUserName, sPasswd);

            if(uID != null){
                ALTPApplication.USER_ID = uID;

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
			e.printStackTrace();
        }
    }

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
