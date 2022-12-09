package edu.hust.tu.projecti.question;

public class QuestionContent {
    public int id;
    public String question;
    public String[] answers;
    public int rightAnswer;

    public QuestionContent(){
        answers = new String[4];
    }
}
