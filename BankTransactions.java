package org.example;

import java.util.*;
import java.nio.file.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BankTransactions {
    private String FILE_NAME = "users_data.json";
    private User user;
    private String username;

    public BankTransactions(User user) {
        this.user = user;
        this.username = user.getUsername();
    }

    public int deposit() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + username + ", welcome to Aet Bank!");
        System.out.print("Please enter the amount you want to deposit: ");
        int amount = sc.nextInt();

        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return deposit();
        } else {
            int newBalance = user.getBalance() + amount;
            user.setBalance(newBalance);
            System.out.println("You have successfully deposited " + amount + ". Your new balance is: " + user.getBalance());
        }
        return user.getBalance();
    }

    public int withdraw() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello " + username + ", welcome to Aet Bank!");

        if (user.getBalance() <= 0) {
            System.out.println("Your balance is zero. You cannot withdraw money.");
            return 0;
        }

        System.out.print("Please enter the amount you want to withdraw: ");
        int amount = sc.nextInt();

        if(amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
            return withdraw();
        } else if(amount > user.getBalance()) {
            System.out.println("Insufficient balance. You cannot withdraw more than your current balance of " + user.getBalance() + ".");
            return withdraw();
        } else {
            int newBalance = user.getBalance() - amount;
            user.setBalance(newBalance);
            System.out.println("You have successfully withdrawn " + amount + ". Your new balance is: " + user.getBalance());
        }
        return user.getBalance();
    }

    public void displayInfo() {
        System.out.println("User Information:");
        if (username == null || username.isEmpty()) {
            System.out.println("Username: Not set");
        } else {
            System.out.println("Username: " + username);
            System.out.println("Balance: " + user.getBalance());
        }
    }

    public void updateInfo() {
        Gson gson = new Gson();
        try {
            String data = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            List<User> users = gson.fromJson(data, new TypeToken<List<User>>(){}.getType());
            if(users == null) users = new ArrayList<>();

            boolean found = false;
            for(int i = 0; i < users.size(); i++) {
                if(users.get(i).getUsername().equals(this.username)) {
                    User updatedUser = new User(this.username, users.get(i).getPassword(), this.user.getBalance());
                    users.set(i, updatedUser);
                    found = true;
                    break;
                }
            }

            if(!found) {
                System.out.println("Warning: User not found in file during update.");
                return;
            }

            String updatedData = gson.toJson(users);
            Files.write(Paths.get(FILE_NAME), updatedData.getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error updating user information: " + e.getMessage());
        }
    }
}
