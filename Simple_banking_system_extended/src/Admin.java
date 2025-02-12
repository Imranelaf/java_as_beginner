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
				switch(choice){
					case 1:
					System.out.println("Create a new user");
					break;
					
					case 2:
					startUserMenu();
					break;
					
					case 3: 
					System.out.println("Delete the user");
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
		
	
	}
