package edu.hust.tu.projecti.services;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionService {
	public static ResultSet getQuestions(int level, int amount) throws SQLException {
		String sqlQuery = "SELECT * FROM Questions WHERE QLevel = ? ORDER BY RANDOM() LIMIT ?;";

		var connection = Database.getConnection();

		var statement = connection.prepareStatement(sqlQuery);
		statement.setString(1, Integer.toString(level));
		return statement.executeQuery();
	}


}
