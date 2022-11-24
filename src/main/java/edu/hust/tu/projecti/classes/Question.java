package edu.hust.tu.projecti.classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class Question {
	private static final String sqlQuery = "SELECT * FROM Questions WHERE QLevel = ? ORDER BY RANDOM() LIMIT 1;";
	private Connection connection;
    private int id;
    private String question;        public String getQuestion() {return question;}
    private List<String> answers;   public List<String> getAnswers() {return answers;}
    private int rightAnswer;        public int getRightAnswer() {return rightAnswer;}

    /**
     * Constructor of question
     * @param connection Connection to ProjectI database
     * @param level Used to take equivalent Qlevel in database
     */
    public Question(Connection connection, int level){
        this.answers = new ArrayList<String>(4);
		this.connection = connection;

        this.refreshQuestion(level);
        
    }
	
	/**
	 * This method refresh Question with another one at level = level
	 * <b> Note </b> In this project, at least 5 Question object is needed.
	 */
	public void refreshQuestion(int level){
		try {
            var statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, Integer.toString(level));
            var sqlQuestion = statement.executeQuery();
            sqlQuestion.next();
            this.id = sqlQuestion.getInt("QID");
            this.question = sqlQuestion.getString("Question");
            this.answers.clear();
            this.answers.add(0, sqlQuestion.getString("RightAnswer"));
            this.answers.add(1, sqlQuestion.getString("WrongAnswer1"));
            this.answers.add(2, sqlQuestion.getString("WrongAnswer2"));
            this.answers.add(3, sqlQuestion.getString("WrongAnswer3"));
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

    @Override
    public int hashCode() {
        return Integer.hashCode(this.id);
    }
}
