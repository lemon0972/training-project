package org.example;

import java.sql.*;
import java.util.regex.Pattern;

public class UserCRUD {

    // Regex kiem tra dinh dang email
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static void createUser(String name, String email, int age) {
        String sql = "INSERT INTO users (name, email, age) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Tao nguoi dung thanh cong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readUsers() {
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(String currentName, String newName,String newEmail, int newAge) {
        String sql = "UPDATE users SET name = ?, email = ?, age = ? WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setString(2, newEmail);
            pstmt.setInt(3, newAge);
            pstmt.setString(4, currentName);
            pstmt.executeUpdate();
            System.out.println("Cap nhat nguoi dung thanh cong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(String name) {
        if (!doesUserExist(name)) {
            System.out.println("Nguoi dung voi ten " + name + " khong ton tai.");
            return;
        }

        String sql = "DELETE FROM users WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Xoa nguoi dung thanh cong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Kiem tra dinh dang email
    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    // kiem tra xem user co ton tai khong
    public static boolean doesUserExist(String name) {
        String sql = "SELECT COUNT(*) FROM users WHERE name = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

