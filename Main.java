import java.util.Scanner;

public class Main {
    public  static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account();

        System.out.println("Welcome to Kaya Bank!");
        System.out.println("Please make a choice");
        System.out.println("1. Create an account | 2. Login | 3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: account.userRegistration(); break;
            case 2: account.userLogin(); break;
            case 3:
                System.out.println("Thank you for using Kaya Bank. Goodbye!");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
