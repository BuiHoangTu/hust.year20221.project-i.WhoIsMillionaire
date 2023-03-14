package edu.hust.tu.projecti;

import edu.hust.tu.projecti.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {
    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField tfPasswd;
    @FXML
    private Label lWarning;
    @FXML
    private Button bConfirmSignUp;

    private boolean isSignedUp = false;

    public SignUpController() {
    }

    @FXML
    protected void onClickConfirmSignUp() {
        if (isSignedUp){
            toLogIn();
        } else {
            signUp();
        }

    }
    @FXML
    protected void onClickToLogIn(){
        toLogIn();
    }


    //Private Function
    private void signUp(){
        String sUserName = tfUserName.getText();
        String sPasswd = tfPasswd.getText();

        try{
            UserService.signUp(sUserName, sPasswd);

            isSignedUp = true;
            lWarning.setText("Your account is created");
            lWarning.setTextFill(Paint.valueOf("Blue"));
            lWarning.setVisible(true);
            bConfirmSignUp.setText("Go To Login Page");
            tfPasswd.setDisable(true);
            tfUserName.setDisable(true);


        }catch (SQLException e) {
            //19 is UserName UNIQUE
            if (e.getErrorCode() == 19){
				lWarning.setText("Tài khoản đã tồn tại");
				lWarning.setTextFill(Color.RED);
                lWarning.setVisible(true);
            } else {
				lWarning.setText("Lỗi server! Thử lại sau");
				lWarning.setTextFill(Color.ORANGE);
				lWarning.setVisible(true);
			}
        }
    }

    private void toLogIn(){
        FXMLLoader fxmlLoader = new FXMLLoader(LogInController.class.getResource("LogIn-view.fxml"));
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



