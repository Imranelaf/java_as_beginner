class Main{
	
	public static void main(String[] arg){
		
		boolean isAdmin = true;
		
		if(isAdmin){
			Admin admin = new Admin();
			admin.startAdminMenu();
			
			}else{
			User user = new User();
			user.startUserMenu();

				}
		}
	
	}
