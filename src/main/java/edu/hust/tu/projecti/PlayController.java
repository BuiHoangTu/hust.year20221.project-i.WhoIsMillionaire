package edu.hust.tu.projecti;

import edu.hust.tu.projecti.services.Database;
import edu.hust.tu.projecti.question.P1QuestionSet;
import edu.hust.tu.projecti.question.QuestionContent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;


public class PlayController implements Initializable {

    @FXML
    private Label lQuestionField;
    @FXML
    private Button bAnswer1, bAnswer2, bAnswer3, bAnswer4, bHalfHelp, bCallHelp, bAudienceHelp;
    @FXML
    private Label lAward1, lAward2, lAward3, lAward4, lAward5, lAward6, lAward7, lAward8, lAward9,
            lAward10, lAward11, lAward12, lAward13, lAward14, lAward15;
    private final P1QuestionSet questionSet = new P1QuestionSet();

    private int currentQuestion = 0;
    private String currentPrize = "0";

//    private final Label[] lAwards = new Label[] {lAward1, lAward2, lAward3, lAward4, lAward5, lAward6, lAward7 ,lAward8 ,lAward9,
//            lAward10, lAward11, lAward12, lAward13, lAward14, lAward15};

    public void returnHome(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home-view.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void dialogLose(ActionEvent event) {
        System.out.println(currentPrize);
        int saveScore = Integer.parseInt(currentPrize.trim().replace(".", ""));
        Database.setScore(ALTPApplication.USER_ID, saveScore);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Tiếc quá");
        alert.setHeaderText("Bạn đã kết thúc phần chơi với số tiền: " + currentPrize.trim() + "đ");
        alert.setContentText("Trở về màn hình chính?");
        ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(okButton, noButton);
        alert.showAndWait().ifPresent(type -> {
            if (type == okButton) {
                try {
                    returnHome(event);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                bAnswer1.setDisable(true);
                bAnswer2.setDisable(true);
                bAnswer3.setDisable(true);
                bAnswer4.setDisable(true);
            }
        });
    }

    public void handleAnswer(Label[] lAwards) {
        QuestionContent currentQuestionContent = questionSet.questions[currentQuestion];
        String rightAnswer = currentQuestionContent.answers[currentQuestionContent.rightAnswer];
        bAnswer1.setOnAction(event -> {
            if (bAnswer1.getText().equals(rightAnswer)) {
                currentPrize = lAwards[currentQuestion].getText().substring(3);
                if (currentQuestion < 14) {
                    setQuestion(questionSet.questions[++currentQuestion], lAwards);
                } else {
                    Alert warning = new Alert(Alert.AlertType.CONFIRMATION);
                    warning.setTitle("Congrats");
                    warning.setContentText("End game");
                    warning.show();
                }
            } else dialogLose(event);
        });
        bAnswer2.setOnAction(event -> {
            if (bAnswer2.getText().equals(rightAnswer)) {
                currentPrize = lAwards[currentQuestion].getText().substring(3);
                if (currentQuestion < 14) {
                    setQuestion(questionSet.questions[++currentQuestion], lAwards);
                } else {
                    Alert warning = new Alert(Alert.AlertType.CONFIRMATION);
                    warning.setTitle("Congrats");
                    warning.setContentText("End game");
                    warning.show();
                }
            } else dialogLose(event);
        });
        bAnswer3.setOnAction(event -> {
            if (bAnswer3.getText().equals(rightAnswer)) {
                currentPrize = lAwards[currentQuestion].getText().substring(3);
                if (currentQuestion < 14) {
                    setQuestion(questionSet.questions[++currentQuestion], lAwards);
                } else {
                    Alert warning = new Alert(Alert.AlertType.CONFIRMATION);
                    warning.setTitle("Congrats");
                    warning.setContentText("End game");
                    warning.show();
                }
            } else dialogLose(event);
        });
        bAnswer4.setOnAction(event -> {
            if (bAnswer4.getText().equals(rightAnswer)) {
                currentPrize = lAwards[currentQuestion].getText().substring(3);
                if (currentQuestion < 14) {
                    setQuestion(questionSet.questions[++currentQuestion], lAwards);
                } else {
                    Alert warning = new Alert(Alert.AlertType.CONFIRMATION);
                    warning.setTitle("Congrats");
                    warning.setContentText("End game");
                    warning.show();
                }
            } else dialogLose(event);
        });
    }

    public void showAward(Label[] lAwards) {
        for (int i = 0; i < 15; i++) {
            System.out.println("I: " + i + ", currentQuestion: " + currentQuestion);
            if ((i == currentQuestion)) {
                lAwards[i].setTextFill(Color.WHITE);
            } else {
                lAwards[i].setTextFill(Color.GRAY);
            }
        }
    }

    public void setQuestion(QuestionContent currentQuestion, Label[] lAwards) {
        showAward(lAwards);
        lQuestionField.setText(currentQuestion.question);
        bAnswer1.setVisible(true);
        bAnswer2.setVisible(true);
        bAnswer3.setVisible(true);
        bAnswer4.setVisible(true);
        bAnswer1.setText(currentQuestion.answers[0]);
        bAnswer2.setText(currentQuestion.answers[1]);
        bAnswer3.setText(currentQuestion.answers[2]);
        bAnswer4.setText(currentQuestion.answers[3]);
        handleAnswer(lAwards);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Label[] lAwards = new Label[]{lAward1, lAward2, lAward3, lAward4, lAward5, lAward6, lAward7, lAward8, lAward9,
                lAward10, lAward11, lAward12, lAward13, lAward14, lAward15};

        for (int i = 0; i < 15; i++) {
            var q = questionSet.questions[i];
            System.out.println(q.question);
            for (var a : q.answers) {
                System.out.println("\t" + a);
            }
            System.out.println("TRUE " + "True Index : " + q.rightAnswer + " Value :" + q.answers[q.rightAnswer] + "\n\n\n");


        }

        setQuestion(questionSet.questions[currentQuestion], lAwards);

        bHalfHelp.setOnAction(event -> {
            int currentAnsIndex = questionSet.questions[currentQuestion].rightAnswer;
            ArrayList<Button> bAnswers = new ArrayList<>();
            bAnswers.add(bAnswer1);
            bAnswers.add(bAnswer2);
            bAnswers.add(bAnswer3);
            bAnswers.add(bAnswer4);
            bAnswers.remove(currentAnsIndex);
            Collections.shuffle(bAnswers);
            bAnswers.get(0).setVisible(false);
            bAnswers.get(1).setVisible(false);
            bHalfHelp.setDisable(true);
        });

        bCallHelp.setOnAction(event -> {
            String currentAns = questionSet.questions[currentQuestion].answers[questionSet.questions[currentQuestion].rightAnswer];
            Dialog<String> callHelpDialog = new Dialog<>();
            callHelpDialog.setTitle("Gọi điện thoại cho người thân!");
            callHelpDialog.setContentText("Đang nối máy... Ronaldo nói rằng đáp án là: " + currentAns);
            ButtonType type = new ButtonType("Cảm ơn Ronaldo!", ButtonBar.ButtonData.OK_DONE);
            callHelpDialog.getDialogPane().getButtonTypes().add(type);
            callHelpDialog.showAndWait();
            bCallHelp.setDisable(true);
        });

        bAudienceHelp.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader(ALTPApplication.class.getResource("/edu/hust/tu/projecti/AudienceHelp-view.fxml"));
            try {
                Preferences questionPreferences = Preferences.userRoot();
                questionPreferences.put("answerIndex", String.valueOf(questionSet.questions[currentQuestion].rightAnswer));
                Dialog<String> dialog = new Dialog<>();
                DialogPane pane = loader.load();
                dialog.setDialogPane(pane);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.show();
            } catch (IOException ignored) {}
            bAudienceHelp.setDisable(true);
        });

    }
}

