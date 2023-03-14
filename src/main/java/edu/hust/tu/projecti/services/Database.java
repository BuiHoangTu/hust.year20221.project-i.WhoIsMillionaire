package edu.hust.tu.projecti.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) {
        // set point
        setScore(3, 100);
    }

    private static final String dbURL = "jdbc:sqlite:SQL/sqlite_ProjectI.db";

    private static volatile Connection connection = null;

    public static Connection getConnection(boolean autocommit){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(dbURL);
                connection.setAutoCommit(autocommit);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static Connection getConnection(){
        return getConnection(true);
    }

    /**
     * Add new play result
     * @param UID indicate the user
     * @param score his/her score
     */
    public static void setScore(int UID, int score){
        var sql = "INSERT into Scores(UID, Score) VALUES (?, ?);";
        try {
            var statement = getConnection().prepareStatement(sql);
            statement.setString(1, Integer.toString(UID));
            statement.setInt(2, score);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
