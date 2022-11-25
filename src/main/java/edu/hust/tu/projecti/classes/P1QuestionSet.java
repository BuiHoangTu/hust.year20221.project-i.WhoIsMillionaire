package edu.hust.tu.projecti.classes;

import edu.hust.tu.projecti.ALTPApplication;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h1> QUESTION </h1>
 * This class is an implement of question in database.
 * Each new object take a random question in database
 * with level associate with level marked database
 * <b>Note:</b> In this project, you will need to check
 * for repeated questions.
 * Create a List Question and a loop to push new question in
 * if that question is not already inside. The loop stops
 * when the number of questions is enough.
 */
public class P1QuestionSet {
    private static final String sqlQuery = "SELECT * FROM Questions WHERE QLevel = ? ORDER BY RANDOM() LIMIT 5;";
    public QuestionContent[] questions;

    /**
     * Constructor of question
     */
    public P1QuestionSet(){
        this.questions = new QuestionContent[15];
        for (int i = 0; i < 15; i++){
            questions[i] = new QuestionContent();
        }
        addQuestion(5);
        addQuestion(10);
        addQuestion(15);
    }

    /**
     * This method refresh Question with another one at level = level
     * <b> Note </b> In this project, at least 5 Question object is needed.
     */
    private void addQuestion(int level){
        var connection = ALTPApplication.getConnection();
        try {
            var statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, Integer.toString(level));
            var sqlQuestion = statement.executeQuery();
            for (int i = level - 5; i < level; i++){
                sqlQuestion.next();
                this.questions[i].id = sqlQuestion.getInt("QID");
                this.questions[i].question = sqlQuestion.getString("Question");
                //this.questions[i].answers.clear();
                this.questions[i].answers[0] = sqlQuestion.getString("RightAnswer");
                this.questions[i].answers[1] = sqlQuestion.getString("WrongAnswer1");
                this.questions[i].answers[2] = sqlQuestion.getString("WrongAnswer2");
                this.questions[i].answers[3] = sqlQuestion.getString("WrongAnswer3");

                //shuffle answer and retrieve right answer id
                var tmpR = this.questions[i].answers[0];
                var tmpL = Arrays.asList(this.questions[i].answers);
                Collections.shuffle(tmpL);
                tmpL.toArray(this.questions[i].answers);
                for ( int j = 0; j < 4; j++){
                    if(tmpR.equals(questions[i].answers[j])){
                        this.questions[i].rightAnswer = j;
                        break;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Query failed in taking a question");
        }



    }
}
