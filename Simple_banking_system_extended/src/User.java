import java.util.Scanner;
import java.util.InputMismatchException;

class User {
    static Scanner scanner = new Scanner(System.in);

    public void startUserMenu() {
		
    
        double balance = 0;
        boolean isRunning = true;
        
        
		System.out.println("*************************");
        System.out.println("   Welcome to the Banking Users System   ");
        System.out.println("*************************");
        while (isRunning) {
            displayChoices();
            try{
            System.out.print("Enter your choice: ");
			int userChoice = scanner.nextInt();	
          
            switch (userChoice) {
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    balance += depositAmount();
                    break;
                case 3:
                    balance -= withdrawAmount(balance);
                    break;
                case 4:
					System.out.println("Thank you");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }catch(InputMismatchException e){
			System.out.println("*************************");
			System.out.println("Please enter a valid number");
			System.out.println("*************************");
			scanner.nextLine();
			
			}
        }
        
    }

     void displayChoices() {
        String[] choices = {
            "1 - Show Account Balance",
            "2 - Deposit Amount",
            "3 - Withdraw Amount",
            "4 - Exit"
        };


        for (String choice : choices) {
            System.out.println(choice);
        }
        System.out.println("*************************");
    }

     void showBalance(double amount) {
        System.out.println("*************************");
        System.out.printf("Your current balance: $%.2f%n", amount);
        System.out.println("*************************");
    }

     double depositAmount() {
        System.out.print("Enter the amount to deposit: ");
        try{
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("*************************");
            System.out.println("Deposit amount must be positive.");
            System.out.println("*************************");
            return 0;
        } else {
            System.out.println("*************************");
            System.out.println("Successfully deposited $" + amount);
            System.out.println("*************************");
            return amount;
        }
        }catch(InputMismatchException e){
			System.out.println("*************************");
			System.out.println("The deposition must be a number");
			System.out.println("*************************");
			scanner.nextLine();
			return 0;
			}
    }

     double withdrawAmount(double balance) {
        System.out.print("Enter the amount to withdraw: ");
        try{
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("*************************");
            System.out.println("Insufficient balance! You cannot withdraw more than your available balance.");
            System.out.println("*************************");
            return 0;
        } else if (amount <= 0) {
            System.out.println("*************************");
            System.out.println("Withdrawal amount must be positive.");
            System.out.println("*************************");
            return 0;
        } else {
            System.out.println("*************************");
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("*************************");
            return amount;
        }
        }catch(InputMismatchException e){
			System.out.println("Invalid input");
			scanner.nextLine();
			return 0;
			}
    }

}
