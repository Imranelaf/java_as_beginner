import java.sql.*;

class AdminRole extends HandleUser {
	
	static String login(String username){
		String dbUsername = null;
		try (Connection conn = DriverManager.getConnection(url)) {
			String getUserSQL = "SELECT * FROM users WHERE name=?;";
			PreparedStatement pstmt = conn.prepareStatement(getUserSQL);
			pstmt.setString(1, username);
			ResultSet result = pstmt.executeQuery();
			if(result.next()){
			dbUsername = result.getString("name");}
			else{
				
				dbUsername = "There no user under this name";
				}
		
		}catch (SQLException e) {
			System.out.println("Something went wrong, Please try later");
			return e.getMessage();
			
			}
			return dbUsername;
		
		}
	
	}
