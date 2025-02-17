import java.util.Scanner;

class Login{
	public Scanner scanner = new Scanner(System.in);
	public String checking(){
		System.out.println("****** LOGIN ******");
		System.out.print("Enter your username: ");
		String name = scanner.nextLine();
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
	
		HandleUser user = new HandleUser();
		String result = user.login(name, password);
		
		if(result == null){
			System.out.println("Username Or/and Password incorrect");
			return null;
			}else{
				System.out.println("login successfully");
				return result;
				
				}
		}

}
