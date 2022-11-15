package edu.hust.tu.projecti;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private int id;
    private String question;        public String getQuestion() {
        return question;
    }
    private List<String> answers;   public List<String> getAnswers() {
        return answers;
    }
    private int rightAnswer;        public int getRightAnswer() {
        return rightAnswer;
    }

    //constructor
    public Question(Connection connection, int level){
        this.answers = new ArrayList<String>(4);

        //select a random question
        var sqlQuery = "SELECT * FROM Questions WHERE QLevel = ? ORDER BY RAND() LIMIT 1;";
        try {
            var statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, Integer.toString(level));
            var sqlQuestion = statement.executeQuery();
            sqlQuestion.next();
            this.id = sqlQuestion.getInt("QID");
            this.question = sqlQuestion.getString("Question");
            this.answers.set(0, sqlQuestion.getString("RightAnswer"));
            this.answers.set(1, sqlQuestion.getString("WrongAnswer1"));
            this.answers.set(2, sqlQuestion.getString("WrongAnswer2"));
            this.answers.set(3, sqlQuestion.getString("WrongAnswer3"));
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            System.out.println("Query failed in taking a question");
        }

        //shuffle answer and retrieve right answer id
        var tmpR = this.answers.get(0);
        Collections.shuffle(this.answers);
        for ( var answer : this.answers){
            if(tmpR.equals(answer)){
                this.rightAnswer = this.answers.indexOf(answer);
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Question){
            if(((Question) o).id == this.id) return true;
        }
        return false;
    }

}
