import java.sql.*;
import java.io.File; 

public class Sqlite {
    static String url = "jdbc:sqlite:users.db";

    public static void start() {
		
		File dbFile = new File("users.db"); //check if the database exist or not
		if(!dbFile.exists()){
			createTableIfNotExist();
			}
    }
	//This is method for creating table and the admin if they don't exist
    private static String createTableIfNotExist() {
        try (Connection conn = DriverManager.getConnection(url)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "name TEXT NOT NULL UNIQUE, "
                    + "password TEXT NOT NULL,"
					+ "sold DOUBLE DEFAULT 0 NOT NULL"
                    + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);

            // Insert Admin
            String insertUserSQL = "INSERT OR IGNORE INTO users(name, password) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertUserSQL);
            pstmt.setString(1, "Admin");
            pstmt.setString(2, "1234");
            pstmt.executeUpdate();

            return "Table and Admin created successfully.";
        } catch (SQLException e) {
            return "❌ Error: " + e.getMessage();
        }
    }

    public static String createUser(String name, String password) {
        try (Connection conn = DriverManager.getConnection(url)) {
            createTableIfNotExist();

            String insertUserSQL = "INSERT INTO users(name, password) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertUserSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

            return "User created successfully.";
        } catch (SQLException e) {
            return "❌ Error: " + e.getMessage();
        }
    }

	public static String deleteUser(String name){
		try (Connection conn = DriverManager.getConnection(url)) {
		String deleteUserSQL = "DELETE FROM users WHERE name=?;";
            PreparedStatement pstmt = conn.prepareStatement(deleteUserSQL);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return "The user has been deleted successfully";
		}catch(SQLException e){
			System.out.println("Something went wrong, Please try later");
			return "❌ Error: " + e.getMessage();
			}
		}
}
