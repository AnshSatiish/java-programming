module com.opsdevelop.playergameapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;
    requires java.desktop;

    opens com.opsdevelop.playergameapp to javafx.fxml;
    exports com.opsdevelop.playergameapp;
}