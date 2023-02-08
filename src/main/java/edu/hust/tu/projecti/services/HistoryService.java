package edu.hust.tu.projecti.services;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryService {
    public static void main(String[] args) {
        // get top 2 player
        var res = topPlay(2);
        try{
            while (res.next()) {
                System.out.print(res.getString("Name") + "<--->");
                System.out.print(res.getString("Score") + "<--->");
                System.out.println(res.getString("PlayDate"));
            }
        }catch (SQLException ignored){}

        System.out.println("\n");

        // get last 2 plays of user 1
        res = userLastPlays(2, 1);
        // res.getMetaData();
        try{
            while (res.next()) {
                System.out.print(res.getString("Score") + "<--->");
                System.out.println(res.getString("PlayDate"));
            }
        }catch (SQLException ignored){}
    }

    /**
     * Get top plays' result
     * @param top amount of top plays
     * @return a {@link ResultSet} of best play
     */
    public static ResultSet topPlay(int top){
        var sql = """
                SELECT u.Name, s.Score, s.PlayDate \s
                \tFROM (SELECT * FROM Scores order by Score DESC LIMIT 10) s\s
                \t\tINNER join Users u\s
                \t\ton s.UID = u.UID\s
                \torder by Score DESC LIMIT ? ;""";
        ResultSet res;
        try {
            var statement = Database.getConnection().prepareStatement(sql);
            statement.setString(1, Integer.toString(top));
            res = statement.executeQuery();
        } catch (SQLException ignored) {
			return null;
		}
        return res;
    }

    public static ResultSet userLastPlays(int length, int userID){
        ResultSet res;
        var sql = """
                SELECT *\s
                \tFROM Scores s\s
                \tWHERE s.UID = ?
                \tORDER BY PlayDate DESC\s
                \tLIMIT ?""";
        try {
            var statement = Database.getConnection().prepareStatement(sql);

			statement.setString(1, Integer.toString(userID));
			statement.setString(2, Integer.toString(length));

			res = statement.executeQuery();
        } catch (SQLException ignored){
			return null;
		}
        return res;
    }

}
