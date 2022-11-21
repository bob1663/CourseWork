module sample.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample.coursework to javafx.fxml;
    exports sample.coursework;
    exports sample.coursework.database;
    opens sample.coursework.database to javafx.fxml;
}