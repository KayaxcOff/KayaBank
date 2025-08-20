package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LogIn {
    String FILE_NAME = "users_data.json";

    public void signIn() {
        Scanner sc = new Scanner(System.in);
        BankMenu menu = new BankMenu();

        System.out.println("Welcome to Aet Bank!");
        System.out.print("Please enter your name: ");
        String name = sc.nextLine();
        System.out.print("Please enter your password: ");
        String password = sc.nextLine();

        List<User> users;
        try {
            String json_file = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            users = new Gson().fromJson(json_file, new TypeToken<List<User>>(){}.getType());
            if(users == null) users = new ArrayList<>();
        } catch (Exception e) {
            users = new ArrayList<>();
        }

        boolean found = false;
        User currentUser = null;
        for(User user : users) {
            if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
                found = true;
                currentUser = user;
                break;
            }
        }

        if(found) {
            System.out.println("Login successful! Welcome, " + currentUser.getUsername());
            menu.displayMenu(currentUser);
        } else {
            System.out.println("Login failed! Username or password incorrect.");
        }
    }

    public void signUp() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        List<User> users;
        try {
            String json_file = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            users = new Gson().fromJson(json_file, new TypeToken<List<User>>(){}.getType());
            if(users == null) users = new ArrayList<>();
        } catch (Exception e) {
            users = new ArrayList<>();
        }
        for(User user : users) {
            if(user.getUsername().equals(name)) {
                System.out.println("Username already exists. Please try again.");
                return;
            }
        }

        int temporaryPassword = (int) (Math.random() * 10000);
        System.out.println("Your temporary password is: " + temporaryPassword);
        System.out.print("Please enter your temporary password: ");
        int isTrue = sc.nextInt();
        sc.nextLine();

        if(isTrue != temporaryPassword) {
            System.out.println("Wrong temporary password. Please try again.");
            return;
        }

        System.out.print("Please enter your new password: ");
        String newPassword = sc.nextLine();

        User newUser = new User(name, newPassword, 0);
        users.add(newUser);

        String updatedJson = new Gson().toJson(users);
        try {
            Files.write(Paths.get(FILE_NAME), updatedJson.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("User created successfully!");
            signIn();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
