package com.opsdevelop.studentinfo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudentInfoController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
