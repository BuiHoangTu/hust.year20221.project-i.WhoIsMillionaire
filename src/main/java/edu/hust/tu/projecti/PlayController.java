package edu.hust.tu.projecti;

import edu.hust.tu.projecti.classes.P1QuestionSet;
import edu.hust.tu.projecti.classes.QuestionContent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayController implements Initializable {
    @FXML
    private Label lQuestionField;
    @FXML
    private Button bAnswer1, bAnswer2, bAnswer3, bAnswer4;
    private final P1QuestionSet questionSet = new P1QuestionSet();

    private int currentQuestion = 0;

    public void handleAnswer() {
        QuestionContent currentQuestionContent = questionSet.questions[currentQuestion];
        String rightAnswer = currentQuestionContent.answers[currentQuestionContent.rightAnswer];
        bAnswer1.setOnAction(event -> {
            if (bAnswer1.getText().equals(rightAnswer))  setQuestion(questionSet.questions[++currentQuestion]);
        });
        bAnswer2.setOnAction(event -> {
            if (bAnswer2.getText().equals(rightAnswer))  setQuestion(questionSet.questions[++currentQuestion]);
        });
        bAnswer3.setOnAction(event -> {
            if (bAnswer3.getText().equals(rightAnswer))  setQuestion(questionSet.questions[++currentQuestion]);
        });
        bAnswer4.setOnAction(event -> {
            if (bAnswer4.getText().equals(rightAnswer))  setQuestion(questionSet.questions[++currentQuestion]);
        });
    }

    public void setQuestion(QuestionContent currentQuestion) {
        lQuestionField.setText(currentQuestion.question);
        bAnswer1.setText(currentQuestion.answers[0]);
        bAnswer2.setText(currentQuestion.answers[1]);
        bAnswer3.setText(currentQuestion.answers[2]);
        bAnswer4.setText(currentQuestion.answers[3]);
        handleAnswer();
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
        //handleAnswer();
    }
}

