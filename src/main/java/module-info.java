module edu.hust.tu.projecti {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.prefs;


    opens edu.hust.tu.projecti;
    exports edu.hust.tu.projecti;

	opens edu.hust.tu.projecti.question;
	exports edu.hust.tu.projecti.question;
}