class Main{
	
	public static void main(String[] arg){
		
		String username = null;
		
		//starting the database
		Sqlite data = new Sqlite();
		data.start();
		
		//check the user login
		Login login = new Login();
		while(username == null){
		username = login.checking();
	}
		
		if(username.equals("Admin")){
			Admin admin = new Admin();
			admin.startAdminMenu();
			
			}else{
			User user = new User();
			user.startUserMenu();

				}
		}
	
	}
