import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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
        Screens.homeScreen();
        Scanner sc = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equalsIgnoreCase("X")) { // start of WHILE loop for Home Screen
            userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("X")) {   // start of Conditionals Home Screen
                System.out.println("You have exited out of the application. See you next time :)");
                return;
            } else if (userInput.equalsIgnoreCase("D")) {
                System.out.println("Enter a deposit (e.g. 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00:");
                String deposit = sc.nextLine();
                // TODO say deposit successful, you're back to the previous screen
                System.out.println("Your deposit is made. Now you are back to the previous Screen.\n");
                Screens.homeScreen();
            } else if (userInput.equalsIgnoreCase("P")) {
                System.out.println("Enter a payment (e.g. 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50:");
                String deposit = sc.nextLine();
                // TODO say payment successful, you're back to the previous screen
                System.out.println("Your payment is made. Now you are back to the previous Screen.\n");
                Screens.homeScreen();
            } else if (userInput.equalsIgnoreCase("L")) {
                Screens.ledgerScreen();
                userInput = "";
                while (!userInput.equalsIgnoreCase("H")) {   // start of WHILE loop for Ledger Screen
                    userInput = sc.nextLine();
                    if (userInput.equalsIgnoreCase("H")) {   // start of Conditionals Ledger Screen
                        Screens.homeScreen();
                        break;
                    } else if (userInput.equalsIgnoreCase("A")) {
                        System.out.println("Here is all the entries");
                        //TODO display all the entries
                        // Show Ledger Screen since they will go back to it with "break" below
                        break;
                    } else if (userInput.equalsIgnoreCase("D")) {
                        System.out.println("Here is all your deposits:");
                        //TODO display all the deposits
                        // Show Ledger Screen since they will go back to it with "break" below
                        break;
                    } else if (userInput.equalsIgnoreCase("P")) {
                        System.out.println("Here is all your payments:");
                        //TODO display all the payments
                        // Show Ledger Screen since they will go back to it with "break" below
                        break;
                    } else if (userInput.equalsIgnoreCase("R")) {
                        Screens.reportScreen();
                        int command = -1;
                        while (command != 6) {   // start of WHILE loop for Report Screen
                            command = sc.nextInt();
                            sc.nextLine();
                            if (command == 1) {     // start of Conditionals for Report Screen
                                System.out.println("Month To Date:");
                                //TODO display reports from Month To Date
                                // Show Report Screen since they will go back to it with "break" below
                                break;
                            } else if (command == 2) {
                                System.out.println("Previous Month");
                                //TODO display reports of Previous Month
                                // Show Report Screen since they will go back to it with "break" below
                                break;
                            } else if (command == 3) {
                                System.out.println("Year To Date");
                                //TODO display reports of Year To Date
                                // Show Report Screen since they will go back to it with "break" below
                                break;
                            } else if (command == 4) {
                                System.out.println("Previous Year");
                                //TODO display reports of Previous Year
                                // Show Report Screen since they will go back to it with "break" below
                                break;
                            } else if (command == 5) {
                                System.out.println("search by Vendor");
                                //TODO display all entries for that vendor
                                // Show Report Screen since they will go back to it with "break" below
                                break;
                            } else if (command == 6) {
                                Screens.ledgerScreen();
                                break;
                            } else if (command == 0) {
                                System.out.println("You have exited out of the application. See you next time :)");
                                return;
                            } else {
                                System.out.printf("""
                                        You entered an invalid command: %s
                                        Please try again!
                                        """, command);
                                ;
                            } // end of Report Screen Conditionals
                        } // end of WHILE loop for Report Screen

                    } else if (userInput.equalsIgnoreCase("X")) {
                        System.out.println("You have exited out of the application. See you next time :)");
                        return;
                    } else {
                        System.out.printf("""
                                You entered an invalid command: %s
                                Please try again!
                                """, userInput);
                    } // end of Ledger Screen Conditionals
                } // end of WHILE loop for Ledger Screen
            } else {
                System.out.printf("""
                        You entered an invalid command: %s
                        Please try again!
                        """, userInput);
            } // end of Home Screen Conditionals
        } // end of WHILE loop for Home Screen

    }
}