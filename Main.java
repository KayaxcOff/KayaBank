package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogIn logIn = new LogIn();

        while (true) {
            System.out.println("Welcome to Aet Bank!");
            System.out.println("Here is the menu");
            System.out.println("1. Create Account");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: logIn.signUp(); break;
                case 2: logIn.signIn(); break;
                case 3: sc.close(); System.exit(0); break;
                default: System.out.println("Invalid choice. Please try again."); break;
            }
        }
    }
}
