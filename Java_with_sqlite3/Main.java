import java.util.Scanner;

class Main {
	static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Create a new user
        handleUserInfos();
    }
    
    private static void handleUserInfos(){
		String name;
		String password;
		do{
		System.out.print("Enter the name please: ");
        name = scanner.nextLine();
        }while(name == null || name.trim().isEmpty());
        
		do{
		System.out.print("Enter the password please: ");
        password = scanner.nextLine();
        }while(password == null || password.isEmpty());
		
			
			String result = Sqlite.createUser(name, password);
			System.out.println(result);
		
		}
}
