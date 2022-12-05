package edu.hust.tu.projecti;

import edu.hust.tu.projecti.classes.P1QuestionSet;
import edu.hust.tu.projecti.classes.QuestionContent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {

    @FXML
    private Label questionField;
    @FXML
    private Button answer1, answer2, answer3, answer4;
    private final P1QuestionSet questionSet = new P1QuestionSet();

    private int currentQuestion = 0;

    public void handleAnswer() {
        QuestionContent currentQuestionContent = questionSet.questions[currentQuestion];
        String rightAnswer = currentQuestionContent.answers[currentQuestionContent.rightAnswer];
        answer1.setOnAction(event -> {
            if (answer1.getText().equals(rightAnswer))  setQuestion(questionSet.questions[currentQuestion++]);
        });
        answer2.setOnAction(event -> {
            if (answer2.getText().equals(rightAnswer))  setQuestion(questionSet.questions[currentQuestion++]);
        });
        answer3.setOnAction(event -> {
            if (answer3.getText().equals(rightAnswer))  setQuestion(questionSet.questions[currentQuestion++]);
        });
        answer4.setOnAction(event -> {
            if (answer4.getText().equals(rightAnswer))  setQuestion(questionSet.questions[currentQuestion++]);
        });
    }

    public void setQuestion(QuestionContent currentQuestion) {
        questionField.setText(currentQuestion.question);
        answer1.setText(currentQuestion.answers[0]);
        answer2.setText(currentQuestion.answers[1]);
        answer3.setText(currentQuestion.answers[2]);
        answer4.setText(currentQuestion.answers[3]);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 15; i ++){
            var q = questionSet.questions[i];
            System.out.println(q.question);
            for (var a : q.answers){
                System.out.println("\t" + a);
            }
            System.out.println("TRUE " + "True Index : " + q.rightAnswer + " Value :" + q.answers[q.rightAnswer] + "\n\n\n");
        }
        setQuestion(questionSet.questions[currentQuestion]);
        handleAnswer();
    }
}

