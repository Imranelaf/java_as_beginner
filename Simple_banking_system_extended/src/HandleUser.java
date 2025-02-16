import java.sql.*;

class HandleUser {
	
	static String url = "jdbc:sqlite:users.db";

	// Authenticates the user by verifying the provided username and password against the database records.
	static String login(String username, String password) { 
		try (Connection conn = DriverManager.getConnection(url)) {
			String getUserSQL = "SELECT * FROM users WHERE name=?;";
			PreparedStatement pstmt = conn.prepareStatement(getUserSQL);
			pstmt.setString(1, username);
			ResultSet result = pstmt.executeQuery();
			String dbUsername = result.getString("name");
			String dbPassword = result.getString("password");
			if (dbUsername != null && dbPassword.equals(password)) {
				return dbUsername;
			} else {
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong, Please try later");
			return e.getMessage();
		}
	}

	// Updates the balance of the specified user in the database.
	static void updateBalance(double balance, String username) {
		try (Connection conn = DriverManager.getConnection(url)) {
			String updateUserSQL = "UPDATE users SET sold = ? WHERE name = ?;";
			PreparedStatement pstmt = conn.prepareStatement(updateUserSQL);
			pstmt.setDouble(1, balance);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// Handles deposit or withdrawal operations based on the action provided and updates the user’s balance.
	//and passing the data to the method updateBalance above.
	static void balance(double amount, String username, char action) {
		try (Connection conn = DriverManager.getConnection(url)) {
			double currentBalance;
			String getUserSQL = "SELECT * FROM users WHERE name=?;";
			PreparedStatement pstmt = conn.prepareStatement(getUserSQL);
			pstmt.setString(1, username);
			ResultSet query = pstmt.executeQuery();
			if (query.next()) {
				currentBalance = query.getDouble("sold");
				if (action == 'w') {
					if (currentBalance < amount) {
						System.out.println("Insufficient balance. Your current balance: " + currentBalance);
					} else {
						currentBalance -= amount;
						//those two lines close the connection to the database, otherwise it's gonna be bussy on updateBalance function.
						if (pstmt != null) pstmt.close();
						if (conn != null) conn.close();
						updateBalance(currentBalance, username);
					}
				} else {
					currentBalance += amount;
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
					updateBalance(currentBalance, username);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	//this method run when the user enter to the seasson
	//return the amount in the database
	static double showAmount(String username){
		double currentBalance = Double.NaN;
		try (Connection conn = DriverManager.getConnection(url)) {
			String getUserSQL = "SELECT * FROM users WHERE name=?;";
			PreparedStatement pstmt = conn.prepareStatement(getUserSQL);
			pstmt.setString(1, username);
			ResultSet query = pstmt.executeQuery();
			if (query.next()) {
				currentBalance = query.getDouble("sold");
				
				}
					
			}catch(SQLException e){
				System.out.println(e.getMessage());
				}
			return currentBalance;
		}
		

}
