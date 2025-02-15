import java.util.Scanner;
import java.util.InputMismatchException;

class Admin{
	public Scanner scanner = new Scanner(System.in);
	
	public void startAdminMenu(){
		boolean runing = true;
		
		
		while(runing){
		adminChoices();
		try{
				System.out.print("Please enter your choice: ");
				int choice = scanner.nextInt();
				String message;
				switch(choice){
					case 1:
					message = CreateUser();
					System.out.println("*************************");
					System.out.println(message);
					System.out.println("*************************");
					break;
					
					case 2:
					startUserMenu();
					break;
					
					case 3: 
					message = DeleteUser();
					System.out.println("*************************");
					System.out.println(message);
					System.out.println("*************************");
					break;
					
					case 4:
					runing = false; 
					break;
					
					default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4."); 
					
					}
				
				}catch(InputMismatchException e){
					System.out.println("*************************");
					System.out.println("Invalid input");
					System.out.println("*************************");
					scanner.nextLine();
					}
	}
		
		}
	
	
		void adminChoices(){
			
			System.out.println("*************************");
			System.out.println("   Welcome to the Admin Dashboard ") ;
			System.out.println("*************************");
			System.out.println("1- Create an user");
			System.out.println("2- Show an user informations");
			System.out.println("3- Deleting an user");
			System.out.println("4- Exit the program");
			System.out.println("*************************");
			
			}
			
		void startUserMenu(){
			User user = new User();
			user.startUserMenu();
			}
			
		String CreateUser(){
			scanner.nextLine();	
			System.out.print("Enter the name of the user: ");
			String name = scanner.nextLine();
			
			System.out.print("Enter the password of the user: ");
			String password = scanner.nextLine();
			Sqlite data = new Sqlite();
			String result = data.createUser(name, password);
			return result;
			}
			
		String DeleteUser(){
			scanner.nextLine();
			System.out.print("Enter the name of the user that you want delete: ");
			String name = scanner.nextLine();
			Sqlite data = new Sqlite();
			String result = data.deleteUser(name);
			return result;
			}
		
	
	}
