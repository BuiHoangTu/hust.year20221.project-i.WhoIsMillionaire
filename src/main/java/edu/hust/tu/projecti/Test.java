package edu.hust.tu.projecti;

import edu.hust.tu.projecti.classes.P1QuestionSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static final String dbURL = "jdbc:sqlite:SQL/sqlite_ProjectI.db",
            userName= "root",
            password= "";
    private static volatile Connection connection = null;
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(
                        dbURL
                );
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        /*//một set câu hỏi, đảm bảo các câu khác nhau
        QuestionSet set = new QuestionSet(5);

        for (var i =0; i <5; i++) {
            Question q = new Question(getConnection(), 5);
            //nếu câu hỏi đã có thì đổi
            while(!set.add(q)){
                q.refreshQuestion(5);
                System.out.println("REFRESHED");
            }

            // in thông tin
            System.out.println(q.getQuestion());
            for (var a : q.getAnswers()) {
                System.out.println("\t" + a);
            }
            System.out.println("\n" + q.getRightAnswer() + " NEXT \n");
        }

        // đến đây sẽ có set câu hỏi tiêu chuẩn



        System.out.println("------------------------3--------------------------");
        //câu hỏi số 4
        var q = set.get(3);
        System.out.println(q.getQuestion());
        for (var a : q.getAnswers()) {
            System.out.println("\t" + a);
        }
        System.out.println("\n" + q.getRightAnswer() + " NEXT \n");*/

        //P1
        var p1QS = new P1QuestionSet();
        for (int i = 0; i < 15; i ++){
            var q = p1QS.questions[i];
            System.out.println(q.question);
            for (var a : q.answers){
                System.out.println("\t" + a);
            }
            System.out.println("TRUE " + "True Index : " + q.rightAnswer + " Value :" + q.answers[q.rightAnswer] + "\n\n\n");
        }
    }
}
