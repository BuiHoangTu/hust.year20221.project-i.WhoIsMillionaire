module edu.hust.tu.projecti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens edu.hust.tu.projecti to javafx.fxml;
    exports edu.hust.tu.projecti;
    exports edu.hust.tu.projecti.controllers;
    opens edu.hust.tu.projecti.controllers to javafx.fxml;
    exports edu.hust.tu.projecti.classes;
    opens edu.hust.tu.projecti.classes to javafx.fxml;
}