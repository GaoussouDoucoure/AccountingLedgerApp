import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void homeScreen(){
        System.out.println("""
                *************************************************
                ***** WELCOME TO YOUR ACCOUNTING LEDGER APP *****
                *************************************************
                
                Please choose an option to proceed:
                D - Add Deposit
                P - Make Payment (Debit)
                L - Ledger
                X - Exit the Application
                """);
    }
    public static void ledgerScreen(){
        System.out.println("""
                ***** LEDGER SCREEN *****
                Choose an option to proceed:
                A - Display All Entries
                D - Deposits
                P - Payments
                R - Reports
                H - Go back to Home Page
                X - Exit the Application
                """);
    }
    public static void reportScreen(){
        System.out.println("""
                ***** REPORT SCREEN *****
                Choose an option to proceed:
                1 - Month To Date
                2 - Previous Month
                3 - Year To Date
                4 - Previous Year
                5 - Search by Vendor - prompt the user for the vendor name
                    and display all entries for that vendor
                6 - Go back to Ledger Screen
                0 - Exit the Application
                """);
    }
    public static void main(String[] args) {
        ArrayList<Transaction> transaction = new ArrayList<>();
        File file = new File("transactions.csv");
        try {
            Scanner reader = new Scanner(file);
            if(reader.hasNextLine()){
                String header = reader.nextLine();
//                System.out.println(header); //To cut off the 1st line of the file since they are Titles and all strings which will cause problem on conversion for "amount"
            }
            while(reader.hasNextLine()){
                String line = reader.nextLine();
//                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        homeScreen();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        if(userInput.equalsIgnoreCase("X")){
            System.out.println("You have exited out of the application. See you next time :)");
        } else if (userInput.equalsIgnoreCase("D")) {
            System.out.println("Enter a deposit (e.g. 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00:");
            String deposit = sc.nextLine();
        } else if (userInput.equalsIgnoreCase("P")){
            System.out.println("Enter a payment (e.g. 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50:");
            String deposit = sc.nextLine();
        } else if (userInput.equalsIgnoreCase("L")){
            ledgerScreen();
            userInput = sc.nextLine();
            if(userInput.equalsIgnoreCase("H")){
                homeScreen();
            } else if (userInput.equalsIgnoreCase("A")) {
                System.out.println("Here is all the entries");
                //TODO display all the entries
            } else if (userInput.equalsIgnoreCase("D")) {
                System.out.println("Here is all your deposits:");
                //TODO display all the deposits
            } else if (userInput.equalsIgnoreCase("P")) {
                System.out.println("Here is all your payments:");
                //TODO display all the payments
            } else if (userInput.equalsIgnoreCase("R")) {
                reportScreen();
                int command = sc.nextInt();
                if(command == 1){
                    System.out.println("Month To Date:");
                    //TODO display reports from Month To Date
                } else if (command == 2) {
                    System.out.println("Previous Month");
                    //TODO display reports of Previous Month
                } else if (command == 3) {
                    System.out.println("Year To Date");
                    //TODO display reports of Year To Date
                } else if (command == 4) {
                    System.out.println("Previous Year");
                    //TODO display reports of Previous Year
                } else if (command == 5) {
                    System.out.println("search by Vendor");
                    //TODO display all entries for that vendor
                } else if (command == 6) {
                    ledgerScreen();
                } else if (command == 0) {
                    System.out.println("You have exited out of the application. See you next time :)");
                } else {
                    System.out.println("You have entered an invalid command: " + command);
                } // end of Report Screen Conditionals

            } else if (userInput.equalsIgnoreCase("X")) {
                System.out.println("You have exited out of the application. See you next time :)");
            } else{
                System.out.println("You enter an invalid command: " + userInput);
            } // end of Ledger Screen Conditionals
        } else {
            System.out.println("You enter an invalid command: " + userInput);
        } // end of Home Screen Conditionals


    }
}