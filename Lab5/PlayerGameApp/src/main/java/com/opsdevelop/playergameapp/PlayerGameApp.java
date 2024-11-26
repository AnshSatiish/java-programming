package com.opsdevelop.playergameapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PlayerGameApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Player and Game Manager");

        // Root layout with TabPane
        TabPane tabPane = new TabPane();

        // Add Player Tab
        Tab addPlayerTab = new Tab("Add Player");
        addPlayerTab.setContent(createAddPlayerForm());
        addPlayerTab.setClosable(false);

        // Add Game Tab
        Tab addGameTab = new Tab("Add Game");
        addGameTab.setContent(createAddGameForm());
        addGameTab.setClosable(false);

        // Add Player and Game Tab
        Tab addPlayerGameTab = new Tab("Add Player Game");
        addPlayerGameTab.setContent(createAddPlayerGameForm());
        addPlayerGameTab.setClosable(false);

        // Add tabs to the TabPane
        tabPane.getTabs().addAll(addPlayerTab, addGameTab, addPlayerGameTab);

        // Create Scene and Set Stage
        Scene scene = new Scene(tabPane, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Create the Add Player form.
     */
    private GridPane createAddPlayerForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Form Fields
        TextField playerIdField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField addressField = new TextField();
        TextField postalCodeField = new TextField();
        TextField provinceField = new TextField();
        TextField phoneNumberField = new TextField();
        Button insertPlayerButton = new Button("Add Player");

        // Add Components to Grid
        grid.add(new Label("Player ID:"), 0, 0);
        grid.add(playerIdField, 1, 0);
        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);
        grid.add(new Label("Address:"), 0, 3);
        grid.add(addressField, 1, 3);
        grid.add(new Label("Postal Code:"), 0, 4);
        grid.add(postalCodeField, 1, 4);
        grid.add(new Label("Province:"), 0, 5);
        grid.add(provinceField, 1, 5);
        grid.add(new Label("Phone Number:"), 0, 6);
        grid.add(phoneNumberField, 1, 6);
        grid.add(insertPlayerButton, 1, 7);

        // Button Action
        insertPlayerButton.setOnAction(event -> {
            int playerId = Integer.parseInt(playerIdField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String address = addressField.getText();
            String postalCode = postalCodeField.getText();
            String province = provinceField.getText();
            String phoneNumber = phoneNumberField.getText();

            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.insertPlayer(playerId, firstName, lastName, address, postalCode, province, phoneNumber);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player Added");
            alert.setContentText("Player successfully added to the database!");
            alert.showAndWait();
        });

        return grid;
    }

    /**
     * Create the Add Game form.
     */
    private GridPane createAddGameForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Form Fields
        TextField gameIdField = new TextField();
        TextField gameTitleField = new TextField();
        Button insertGameButton = new Button("Add Game");

        // Add Components to Grid
        grid.add(new Label("Game ID:"), 0, 0);
        grid.add(gameIdField, 1, 0);
        grid.add(new Label("Game Title:"), 0, 1);
        grid.add(gameTitleField, 1, 1);
        grid.add(insertGameButton, 1, 2);

        // Button Action
        insertGameButton.setOnAction(event -> {
            int gameId = Integer.parseInt(gameIdField.getText());
            String gameTitle = gameTitleField.getText();

            GameDAO gameDAO = new GameDAO();
            gameDAO.insertGame(gameId, gameTitle);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Added");
            alert.setContentText("Game successfully added to the database!");
            alert.showAndWait();
        });

        return grid;
    }

    /**
     * Create the Add Player and Game form.
     */
    private GridPane createAddPlayerGameForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Form Fields
        TextField playerIdField = new TextField();
        TextField gameIdField = new TextField();
        DatePicker playingDatePicker = new DatePicker();
        TextField scoreField = new TextField();
        Button insertPlayerGameButton = new Button("Add Player Game");

        // Add Components to Grid
        grid.add(new Label("Player ID:"), 0, 0);
        grid.add(playerIdField, 1, 0);
        grid.add(new Label("Game ID:"), 0, 1);
        grid.add(gameIdField, 1, 1);
        grid.add(new Label("Playing Date:"), 0, 2);
        grid.add(playingDatePicker, 1, 2);
        grid.add(new Label("Score:"), 0, 3);
        grid.add(scoreField, 1, 3);
        grid.add(insertPlayerGameButton, 1, 4);

        // Button Action
        insertPlayerGameButton.setOnAction(event -> {
            int playerId = Integer.parseInt(playerIdField.getText());
            int gameId = Integer.parseInt(gameIdField.getText());
            String playingDate = playingDatePicker.getValue().toString();
            int score = Integer.parseInt(scoreField.getText());

            PlayerAndGameDAO playerAndGameDAO = new PlayerAndGameDAO();
            playerAndGameDAO.insertPlayerAndGame(playerId, gameId, playingDate, score);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Player Game Added");
            alert.setContentText("Player and Game information successfully added to the database!");
            alert.showAndWait();
        });

        return grid;
    }
}
