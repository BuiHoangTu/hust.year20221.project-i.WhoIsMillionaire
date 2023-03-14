package edu.hust.tu.projecti;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.prefs.Preferences;

public class AudienceHelpController {
    public  static Preferences questionPreferences = Preferences.userRoot();
    @FXML
    protected BarChart barChartHelp;
    private int currentCorrectAnswerIndex;

    public int getCurrentCorrectAnswerIndex() {
        return currentCorrectAnswerIndex;
    }

    public void setCurrentCorrectAnswerIndex(int index) {
        this.currentCorrectAnswerIndex = index;
    }
    public void setDataSeries(XYChart.Series dataSeries, String dataName1, int value1,
                              String dataName2, int value2,
                              String dataName3, int value3,
                              String dataName4, int value4) {
        dataSeries.getData().add(new XYChart.Data(dataName1, value1));
        dataSeries.getData().add(new XYChart.Data(dataName2, value2));
        dataSeries.getData().add(new XYChart.Data(dataName3, value3));
        dataSeries.getData().add(new XYChart.Data(dataName4, value4));
    }

    @FXML
    protected void initialize() {
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tỉ lệ (%)");
        int answerIndex = Integer.parseInt(questionPreferences.get("answerIndex", ""));
        System.out.println("Index: " + answerIndex);
        XYChart.Series dataSeries = new XYChart.Series();
        if (answerIndex == 0) setDataSeries(dataSeries, "A", 60,
                "B", 15, "C", 15, "D", 10);
        else if (answerIndex == 1) setDataSeries(dataSeries, "A", 15,
                "B", 60, "C", 10, "D", 15);
        else if (answerIndex == 2) setDataSeries(dataSeries, "A", 10,
                "B", 5, "C", 75, "D", 10);
        else if (answerIndex == 3) setDataSeries(dataSeries, "A", 0,
                "B", 5, "C", 15, "D", 80);
        barChartHelp.getData().add(dataSeries);
        barChartHelp.setTitle("Tỉ lệ bình chọn theo đáp án của khán giả");
    }
}
