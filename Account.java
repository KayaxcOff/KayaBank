import java.io.*;
import java.util.Scanner;

public class Account {
    String FILE_NAME = "users_data_control.txt";

    public void userRegistration() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("Registration successful!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving your data.");
            e.printStackTrace();
        }
        userLogin();
    }

    public void userLogin() {
        Scanner sc = new Scanner(System.in);
        MainPage mainPage = new MainPage();

        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the data.");
            e.printStackTrace();
        }

        if(found) {
            System.out.println("Login successful!");
            mainPage.accountInfo();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
