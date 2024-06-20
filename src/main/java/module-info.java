module org.example.managestudents {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.managestudents to javafx.graphics, javafx.fxml;
    opens org.example.managestudents.controller to javafx.graphics, javafx.fxml;
    exports org.example.managestudents;
}