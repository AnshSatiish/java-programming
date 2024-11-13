package com.opsdevelop.studentinfo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class StudentInfoApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Student Information");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setVgap(8);
        grid.setHgap(10);

        TextField name = new TextField();
        name.setPromptText("Full Name");

        TextField address = new TextField();
        address.setPromptText("Address");

        TextField city = new TextField();
        city.setPromptText("City");

        TextField province = new TextField();
        province.setPromptText("Province");

        TextField postalCode = new TextField();
        postalCode.setPromptText("Postal Code");

        TextField phone = new TextField();
        phone.setPromptText("Phone Number");

        TextField email = new TextField();
        email.setPromptText("Email");

        RadioButton compsci = new RadioButton("Computer Science");
        RadioButton business = new RadioButton("Business");
        ToggleGroup majorGroup = new ToggleGroup();
        compsci.setToggleGroup(majorGroup);
        business.setToggleGroup(majorGroup);

        ComboBox<String> coursebox = new ComboBox<>();
        coursebox.getItems().addAll("Java", "Python", "C#");
        ListView<String> courseList = new ListView<>();
        Button addCourseButton = new Button("Add Course");

        CheckBox studentCouncil = new CheckBox("Student Council");
        CheckBox volunteerWork = new CheckBox("Volunteer Work");
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);

        Button displayButton = new Button("Display");

        grid.add(new Label("Name:"), 0, 0);
        grid.add(name, 1, 0);
        grid.add(new Label("Address:"), 0, 1);
        grid.add(address, 1, 1);
        grid.add(new Label("City:"), 0, 2);
        grid.add(city, 1, 2);
        grid.add(new Label("Province:"), 0, 3);
        grid.add(province, 1, 3);
        grid.add(new Label("Postal Code:"), 0, 4);
        grid.add(postalCode, 1, 4);
        grid.add(new Label("Phone Number:"), 0, 5);
        grid.add(phone, 1, 5);
        grid.add(new Label("Email:"), 0, 6);
        grid.add(email, 1, 6);

        grid.add(compsci, 0, 7);
        grid.add(business, 1, 7);

        grid.add(new Label("Courses:"), 0, 8);
        grid.add(coursebox, 1, 8);
        grid.add(addCourseButton, 1, 9);
        grid.add(courseList, 1, 10);

        grid.add(studentCouncil, 0, 11);
        grid.add(volunteerWork, 1, 11);

        grid.add(displayButton, 0, 12);
        grid.add(displayArea, 1, 12);

        addCourseButton.setOnAction(e -> {
            String selectedCourse = coursebox.getValue();
            if (selectedCourse != null && !courseList.getItems().contains(selectedCourse)) {
                courseList.getItems().add(selectedCourse);
            }
        });

        displayButton.setOnAction(e -> {
            StringBuilder studentInfo = new StringBuilder();
            studentInfo.append("Name: ").append(name.getText()).append("\n")
                    .append("Address: ").append(address.getText()).append("\n")
                    .append("City: ").append(city.getText()).append("\n")
                    .append("Province: ").append(province.getText()).append("\n")
                    .append("Postal Code: ").append(postalCode.getText()).append("\n")
                    .append("Phone Number: ").append(phone.getText()).append("\n")
                    .append("Email: ").append(email.getText()).append("\n");

            RadioButton selectedMajor = (RadioButton) majorGroup.getSelectedToggle();
            if (selectedMajor != null) {
                studentInfo.append("Major: ").append(selectedMajor.getText()).append("\n");
            }

            studentInfo.append("Courses: \n").append(courseList.getItems()).append("\n");
            studentInfo.append("Activities: \n ");

            if (studentCouncil.isSelected()) {
                studentInfo.append("Student Council\n");
            }
            if (volunteerWork.isSelected()) {
                studentInfo.append("Volunteer Work\n");
            }

            displayArea.setText(studentInfo.toString());
        });
        
        Scene scene = new Scene(grid, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
