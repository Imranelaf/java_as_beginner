import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        double balance = 0;
        boolean isRunning = true;
        
        
		System.out.println("*************************");
        System.out.println("   Welcome to the Banking System   ");
        System.out.println("*************************");
        while (isRunning) {
            displayChoices();
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
                    isRunning = exitProgram();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    static void displayChoices() {
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

    static void showBalance(double amount) {
        System.out.println("*************************");
        System.out.printf("Your current balance: $%.2f%n", amount);
        System.out.println("*************************");
    }

    static double depositAmount() {
        System.out.print("Enter the amount to deposit: ");
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
    }

    static double withdrawAmount(double balance) {
        System.out.print("Enter the amount to withdraw: ");
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
    }

    static boolean exitProgram() {
        System.out.println("Thank you for using our banking system. Goodbye!");
        scanner.close();
        return false;
    }
}
