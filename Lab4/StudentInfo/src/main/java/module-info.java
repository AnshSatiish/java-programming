module com.opsdevelop.studentinfo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.opsdevelop.studentinfo to javafx.fxml;
    exports com.opsdevelop.studentinfo;
}