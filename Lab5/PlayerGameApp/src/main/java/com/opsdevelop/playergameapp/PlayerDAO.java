package com.opsdevelop.playergameapp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlayerDAO {
    public void insertPlayer(int playerId, String firstName, String lastName, String address,
                             String postalCode, String province, String phoneNumber) {
        String sql = "INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, playerId);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, address);
            stmt.setString(5, postalCode);
            stmt.setString(6, province);
            stmt.setString(7, phoneNumber);
            stmt.executeUpdate();
            System.out.println("Player inserted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
