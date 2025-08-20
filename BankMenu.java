package org.example;

import java.util.Scanner;

public class BankMenu {
    public void displayMenu(User user) {
        Scanner sc = new Scanner(System.in);
        BankTransactions bank = new BankTransactions(user);

        boolean isValid = true;

        while(isValid) {
            System.out.println("Welcome to Aet Bank!");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Display User Information");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: bank.deposit(); break;
                case 2: bank.withdraw(); break;
                case 3: bank.displayInfo(); break;
                case 4: bank.updateInfo(); isValid = false; System.out.println("Thank you for using Aet Bank!"); break;
                default: System.out.println("Invalid choice. Please try again."); break;
            }
        }
    }
}
