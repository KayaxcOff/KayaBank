import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainPage {
    String FILE_NAME = "information_about_users.txt";

    public int accountInfo() {
        BankTransactions bank = new BankTransactions();
        int mon = (int) bank.transactions();

        int balance = 4000;
        int accountNumber = ThreadLocalRandom.current().nextInt(0, 100);
        String accountName = "Muhammet Kaya";

        balance += mon;
        balance += mon;

        System.out.println("Your account ID is " + accountNumber);
        System.out.println("Your account name is " + accountName);
        System.out.println("Your balance is: " + balance);

        try(
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))
        ) {
            writer.write("Account ID: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance);
            writer.newLine();
            System.out.println("Account information saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving account information.");
            e.printStackTrace();
        }
        return balance;
    }
}
