class Main{
	
	public static void main(String[] arg){
		
		boolean isAdmin = true;
		
		
		Sqlite data = new Sqlite();
		data.start();
				
		if(isAdmin){
			Admin admin = new Admin();
			admin.startAdminMenu();
			
			}else{
			User user = new User();
			user.startUserMenu();

				}
		}
	
	}
