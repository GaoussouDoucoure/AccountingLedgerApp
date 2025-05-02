import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInput = "";

        // Outer loop for the Home Screen
        while (!userInput.equalsIgnoreCase("X")) {
            Screens.homeScreen();  // Display Home Screen
            System.out.print("Enter an option: ");
            userInput = sc.nextLine().trim();

            if (userInput.equalsIgnoreCase("X")) {
                System.out.println("Exiting the application... See you next time!");
                break;
            } else if (userInput.equalsIgnoreCase("D")) {
                // Process deposit here
                System.out.print("Enter deposit date (YYYY-MM-DD, press Enter for today's date): ");
                String dateInput = sc.nextLine().trim();
                String date = dateInput.isEmpty() ? LocalDate.now().toString() : dateInput;

                System.out.print("Enter time (HH:MM:SS, press Enter for current time): ");
                String timeInput = sc.nextLine().trim();
                String time = timeInput.isEmpty() ? LocalTime.now().withNano(0).toString() : timeInput;

                System.out.print("Enter description: ");
                String description = sc.nextLine().trim();

                System.out.print("Enter vendor: ");
                String vendor = sc.nextLine().trim();

                System.out.print("Enter amount (positive value expected): ");
                double amount = Double.parseDouble(sc.nextLine().trim());

                Transaction t = new Transaction(date, time, description, vendor, amount);
                CSVHandler.writeTransaction(t);
            } else if (userInput.equalsIgnoreCase("P")) {
                // Process payment here
                System.out.print("Enter payment date (YYYY-MM-DD, press Enter for today's date): ");
                String dateInput = sc.nextLine().trim();
                String date = dateInput.isEmpty() ? LocalDate.now().toString() : dateInput;

                System.out.print("Enter time (HH:MM:SS, press Enter for current time): ");
                String timeInput = sc.nextLine().trim();
                String time = timeInput.isEmpty() ? LocalTime.now().withNano(0).toString() : timeInput;

                System.out.print("Enter description: ");
                String description = sc.nextLine().trim();

                System.out.print("Enter vendor: ");
                String vendor = sc.nextLine().trim();

                System.out.print("Enter amount (enter as positive, it will be recorded as a negative value): ");
                double amount = Double.parseDouble(sc.nextLine().trim());
                amount = -Math.abs(amount);  // to ensure payment is recorded as a negative value by turning the absolute value of entered number

                Transaction t = new Transaction(date, time, description, vendor, amount);
                CSVHandler.writeTransaction(t);
            } else if (userInput.equalsIgnoreCase("L")) {
                // Enter Ledger Screen: start inner loop
                String ledgerInput = "";
                while (!ledgerInput.equalsIgnoreCase("H")) {
                    Screens.ledgerScreen();  // Display the Ledger Screen
                    System.out.print("Enter a ledger option: ");
                    ledgerInput = sc.nextLine().trim();

                    if (ledgerInput.equalsIgnoreCase("H")) {
                        // User requests to go Home
                        System.out.println("Returning to Home Screen...\n");
                        break;  // Breaks out of the ledger loop back to the Home Screen.
                    } else if (ledgerInput.equalsIgnoreCase("A")) {
                        ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                        System.out.println("----- All Transactions -----");
                        for (Transaction t : transactions) {
                            System.out.println(t);
                        }

                    } else if (ledgerInput.equalsIgnoreCase("D")) {
                        ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                        System.out.println("----- Deposits -----");
                        for (Transaction t : transactions) {
                            if (t.getAmount() > 0) {
                                System.out.println(t);
                            }
                        }

                    } else if (ledgerInput.equalsIgnoreCase("P")) {
                        ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                        System.out.println("----- Payments -----");
                        for (Transaction t : transactions) {
                            if (t.getAmount() < 0) {
                                System.out.println(t);
                            }
                        }

                    } else if (ledgerInput.equalsIgnoreCase("R")) {
                        // Enter Report Screen: another inner loop
                        String reportInput = "";
                        while (!reportInput.equals("6")) {
                            Screens.reportScreen();  // Display report menu
                            System.out.print("Enter a report option: ");
                            reportInput = sc.nextLine().trim();

                            if (reportInput.equals("1")) {   // Month To Date Report
                                LocalDate today = LocalDate.now();
                                String yearMonth = today.toString().substring(0, 7);
                                ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                                System.out.println("----- Month To Date Report -----");
                                for (Transaction t : transactions) {
                                    if (t.getDate().startsWith(yearMonth)) {
                                        System.out.println(t);
                                    }
                                }

                            } else if (reportInput.equals("2")) {   // Previous Month Report
                                LocalDate today = LocalDate.now();
                                LocalDate prevMonth = today.minusMonths(1);
                                String prevYearMonth = prevMonth.toString().substring(0, 7);
                                ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                                System.out.println("----- Previous Month Report -----");
                                for (Transaction t : transactions) {
                                    if (t.getDate().startsWith(prevYearMonth)) {
                                        System.out.println(t);
                                    }
                                }

                            } else if (reportInput.equals("3")) { // Year To Date Report
                                LocalDate today = LocalDate.now();
                                String currentYear = today.toString().substring(0, 4);
                                ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                                System.out.println("----- Year To Date Report -----");
                                for (Transaction t : transactions) {
                                    if (t.getDate().startsWith(currentYear)) {
                                        System.out.println(t);
                                    }
                                }

                            } else if (reportInput.equals("4")) { // Previous Year Report
                                LocalDate today = LocalDate.now();
                                int previousYear = Integer.parseInt(today.toString().substring(0, 4)) - 1;
                                String prevYearStr = String.valueOf(previousYear);
                                ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                                System.out.println("----- Previous Year Report -----");
                                for (Transaction t : transactions) {
                                    if (t.getDate().startsWith(prevYearStr)) {
                                        System.out.println(t);
                                    }
                                }

                            } else if (reportInput.equals("5")) {   // Search by Vendor
                                System.out.print("Enter vendor name to search: ");
                                String vendorName = sc.nextLine().trim();
                                ArrayList<Transaction> transactions = CSVHandler.readTransactions();
                                System.out.println("----- Entries for Vendor: " + vendorName + " -----");
                                for (Transaction t : transactions) {
                                    if (t.getVendor().equalsIgnoreCase(vendorName)) {
                                        System.out.println(t);
                                    }
                                }

                            } else if (reportInput.equals("6")) {
                                System.out.println("Returning to Ledger Screen...\n");
                                break;  // Exit the report loop back to the ledger screen.
                            } else if (reportInput.equals("0")) {
                                System.out.println("Exiting the application... See you next time!");
                                return;  // Exit the entire application.
                            } else {
                                System.out.printf("You entered an invalid report option: %s. Please try again!\n", reportInput);
                            }
                        }

                    } else if (ledgerInput.equalsIgnoreCase("X")) {
                        System.out.println("Exiting the application... See you next time!");
                        return;   // Exit the entire application.
                    } else {
                        System.out.printf("You entered an invalid ledger option: %s. Please try again!\n", ledgerInput);
                    }
                }  // End of ledger inner loop.
                // After breaking out of the ledger loop, the outer home loop will re-display the Home Screen.
            } else {
                System.out.printf("You entered an invalid option: %s. Please try again!\n", userInput);
            }
        }  // End of Home Screen loop.

        System.out.println("Application has terminated.");
        sc.close();
    }
}
