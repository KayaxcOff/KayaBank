import java.util.Scanner;

public class BankTransactions {
    public double transactions() {
        Scanner scan = new Scanner(System.in);

        double resultMoney = 0.0;
        boolean loop = true;
        while (loop) {
            System.out.println("Welcome to Bank Transactions");
            System.out.println("Please make a choice:");
            System.out.println("1. Withdraw Money | 2. Deposit Money | 3. Exit");
            int choice = scan.nextInt();

            if( choice == 1) {
                System.out.print("Enter the amount to withdraw: ");
                double moneyWithdraw = scan.nextDouble();
                resultMoney = withdraw(moneyWithdraw);
            } else if(choice == 2) {
                System.out.print("Enter the amount to deposit: ");
                double moneyDeposit = scan.nextDouble();
                resultMoney = deposit(moneyDeposit);
            } else if(choice == 3) {
                System.out.println("Thank you for using Kaya Bank. Goodbye!");
                loop = false;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        return resultMoney;
    }

    public double withdraw(double moneyWithdraw) {
        MainPage mainPage = new MainPage();
        int balance = mainPage.accountInfo();

        if(moneyWithdraw < 0 || moneyWithdraw > balance) {
            System.out.println("You cannot withdraw a negative amount or more than your balance.");
            return 0;
        } else {
            System.out.println("You have successfully withdrawn: " + moneyWithdraw);
            return moneyWithdraw;
        }
    }

    public double deposit(double moneyDeposit) {
        if(moneyDeposit < 0) {
            System.out.println("You cannot deposit a negative amount.");
            return 0;
        } else {
            System.out.println("You have successfully deposited: " + moneyDeposit);
            return moneyDeposit;
        }
    }
}
