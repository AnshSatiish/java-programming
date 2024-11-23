package com.opsdevelop.playergameapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportViewer {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Player Reports");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Set up the JTable with a DefaultTableModel
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Player ID", "First Name", "Last Name", "Game Title", "Score"});
        table.setModel(model);

        // Add a scroll pane to the table
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        // Load data into the table
        loadData(model);

        // Display the frame
        frame.setVisible(true);
    }

    /**
     * Method to load data from the database into the table model
     *
     * @param model DefaultTableModel to populate
     */
    private static void loadData(DefaultTableModel model) {
        String query = """
            SELECT Player.player_id, first_name, last_name, game_title, score 
            FROM PlayerAndGame 
            JOIN Player ON PlayerAndGame.player_id = Player.player_id 
            JOIN Game ON PlayerAndGame.game_id = Game.game_id
            """;

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Check if any data is retrieved
            boolean hasData = false;

            // Iterate through the result set and add rows to the table model
            while (rs.next()) {
                hasData = true;
                System.out.println("Fetched Row: Player ID = " + rs.getInt("player_id")); // Debug log
                model.addRow(new Object[]{
                        rs.getInt("player_id"),       // Player ID
                        rs.getString("first_name"),  // First Name
                        rs.getString("last_name"),   // Last Name
                        rs.getString("game_title"),  // Game Title
                        rs.getInt("score")           // Score
                });
            }

            if (!hasData) {
                System.out.println("No data found in the database.");
                JOptionPane.showMessageDialog(null, "No data found in the database!",
                        "No Data", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            System.err.println("Error occurred while fetching data:");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from the database.\n" + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
