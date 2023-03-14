package edu.hust.tu.projecti;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class AudienceHelpController {
    @FXML
    BarChart barChartHelp;
    private int currentCorrectAnswerIndex;

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
        System.out.println(currentCorrectAnswerIndex);
        XYChart.Series dataSeries = new XYChart.Series();
        if (currentCorrectAnswerIndex == 0) setDataSeries(dataSeries, "A", 60,
                "B", 15, "C", 15, "D", 10);
        else if (currentCorrectAnswerIndex == 1) setDataSeries(dataSeries, "A", 15,
                "B", 60, "C", 10, "D", 15);
        else if (currentCorrectAnswerIndex == 2) setDataSeries(dataSeries, "A", 10,
                "B", 5, "C", 75, "D", 10);
        else if (currentCorrectAnswerIndex == 3) setDataSeries(dataSeries, "A", 0,
                "B", 5, "C", 15, "D", 80);
        barChartHelp.getData().add(dataSeries);
        barChartHelp.setTitle("Tỉ lệ bình chọn theo đáp án của khán giả");
    }
}
