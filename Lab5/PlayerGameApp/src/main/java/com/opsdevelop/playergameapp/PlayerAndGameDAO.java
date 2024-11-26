package com.opsdevelop.playergameapp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PlayerAndGameDAO {
    public void insertPlayerAndGame(int playerId, int gameId, String playingDate, int score) {
        String query = "INSERT INTO PlayerAndGame (player_id, game_id, playing_date, score) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, playerId);
            pstmt.setInt(2, gameId);
            pstmt.setString(3, playingDate);
            pstmt.setInt(4, score);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
