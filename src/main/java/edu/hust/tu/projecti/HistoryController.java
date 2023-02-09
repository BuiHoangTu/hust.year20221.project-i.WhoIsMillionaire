package edu.hust.tu.projecti;

import edu.hust.tu.projecti.services.HistoryService;
import edu.hust.tu.projecti.util.IndexCallBack;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryController {
	// region fxml
	@FXML
	protected TableView<PersonalRecord> tvPersonal;
	@FXML
	protected TableView<WorldRecord> tvWorld;
	// endregion
	private final int uID;


	public HistoryController(int uID) {
		this.uID = uID;
	}


	@FXML
	protected void initialize() {
		// region personal
		ResultSet rsPersonal = HistoryService.userLastPlays(10, uID);
		List<PersonalRecord> personals = new ArrayList<>();
		try {
			while (rsPersonal.next()) {
				personals.add(new PersonalRecord(
						rsPersonal.getString("Score"),
						rsPersonal.getString("PlayDate")));
			}
		} catch (SQLException ignored) {}

		{
			tvPersonal.setItems(FXCollections.observableList(personals));
			// index
			TableColumn<PersonalRecord, Integer> colIndex = new TableColumn<>("#");
			colIndex.setCellValueFactory(new IndexCallBack<>());
			colIndex.prefWidthProperty().bind(tvPersonal.widthProperty().multiply(0.2));
			// playDate
			TableColumn<PersonalRecord, String> colDate = new TableColumn<>("Play Date");
			colDate.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getPlayDate()));
			colDate.prefWidthProperty().bind(tvPersonal.widthProperty().multiply(0.3));
			// score
			TableColumn<PersonalRecord, String> colScore = new TableColumn<>("Score");
			colScore.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getScore()));
			colScore.prefWidthProperty().bind(tvPersonal.widthProperty().multiply(0.5));
			// add column
			tvPersonal.getColumns().addAll(colIndex, colDate, colScore);
		}
		// endregion

		// region world
		ResultSet rsWorld = HistoryService.topPlay(10);
		List<WorldRecord> worlds = new ArrayList<>();
		try {
			while (rsWorld.next()) {
				worlds.add(new WorldRecord(
						rsWorld.getString("Name"),
						rsWorld.getString("Score"),
						rsWorld.getString("PlayDate")));
			}
		} catch (SQLException ignored) {}

		{
			tvWorld.setItems(FXCollections.observableList(worlds));
			// index
			TableColumn<WorldRecord, Integer> colIndex = new TableColumn<>("#");
			colIndex.setCellValueFactory(new IndexCallBack<>());
			colIndex.prefWidthProperty().bind(tvWorld.widthProperty().multiply(0.15));
			// name
			TableColumn<WorldRecord, String> colName = new TableColumn<>("Name");
			colName.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getName()));
			colName.prefWidthProperty().bind(tvWorld.widthProperty().multiply(0.3));
			// playDate
			TableColumn<WorldRecord, String> colDate = new TableColumn<>("Play Date");
			colDate.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getPlayDate()));
			colDate.prefWidthProperty().bind(tvWorld.widthProperty().multiply(0.25));
			// score
			TableColumn<WorldRecord, String> colScore = new TableColumn<>("Score");
			colScore.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getScore()));
			colScore.prefWidthProperty().bind(tvWorld.widthProperty().multiply(0.3));
			// add column
			tvWorld.getColumns().addAll(colIndex, colName, colDate, colScore);
		}
		// endregion
	}


	private static class PersonalRecord {
		private final String score;
		private final String playDate;

		public PersonalRecord(String score, String playDate) {
			this.score = score;
			this.playDate = playDate;
		}

		public String getScore() {
			return score;
		}
		public String getPlayDate() {
			return playDate;
		}
	}

	private static class WorldRecord extends PersonalRecord{
		private final String name;

		public WorldRecord(String name, String score, String playDate) {
			super(score, playDate);
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
