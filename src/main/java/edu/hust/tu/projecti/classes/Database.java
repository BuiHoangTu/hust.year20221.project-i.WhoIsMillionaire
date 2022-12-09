package edu.hust.tu.projecti.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
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

    public static void setScore(int UID, int score){
        var c = getConnection();
        try {
            var statement = connection.prepareStatement("Insert");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
