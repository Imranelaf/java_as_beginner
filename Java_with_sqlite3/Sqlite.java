import java.sql.*;

public class Sqlite {
    static String url = "jdbc:sqlite:users.db";
    
      

    // Method to create the table if it doesn't exist
    private static String createTableIfNotExist() {
        try (Connection conn = DriverManager.getConnection(url)) {
            // Creating the table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" //sql params
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name TEXT NOT NULL, "
                    + "password TEXT NOT NULL"
                    + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);
            return "Table created successfully";
        } catch (SQLException e) {
            return ("❌ Error: " + e.getMessage());
        }
    }

    // Method to create a new user
    public static String createUser(String name, String password) {  // Changed password to String
        try (Connection conn = DriverManager.getConnection(url)) {
            // Ensure that the table are exist
            createTableIfNotExist();

            // Insert the new user
            String insertUserSQL = "INSERT INTO users(name, password) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertUserSQL);
            //to insert data using PreparedStatement you must include one by one and each with thier params starting from 1
            pstmt.setString(1, name);  // here 1 for the name
            pstmt.setString(2, password);  // here 2 for password 
            // they gonna save in the database with the order that you make in this examlpe name then password
            pstmt.executeUpdate(); //execute the commande
            return "User created successfully";
        } catch (SQLException e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}
