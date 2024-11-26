package com.opsdevelop.playergameapp;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameDAO {
    public void insertGame(int gameId, String gameTitle) {
        String query = "INSERT INTO Game (game_id, game_title) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, gameId);
            pstmt.setString(2, gameTitle);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
