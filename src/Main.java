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
                System.out.println("You have exited the application. See you next time!");
                break;
            } else if (userInput.equalsIgnoreCase("D")) {
                // Process deposit here
                System.out.println("Enter a deposit (e.g. 2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00): ");
                String depositInput = sc.nextLine();
                // TODO: Process deposit and add to ledger.
                System.out.println("Your deposit was successful. Returning to Home Screen.\n");
                // After the action, the loop restarts and re-displays the home screen.
            } else if (userInput.equalsIgnoreCase("P")) {
                // Process payment here
                System.out.println("Enter a payment (e.g. 2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50): ");
                String paymentInput = sc.nextLine();
                // TODO: Process payment and add to ledger.
                System.out.println("Your payment was successful. Returning to Home Screen.\n");
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
                        System.out.println("Displaying all entries...");
                        // TODO: Display all ledger entries.
                        // Re-display the ledger screen after completing the task.
                        continue;
                    } else if (ledgerInput.equalsIgnoreCase("D")) {
                        System.out.println("Displaying all deposits...");
                        // TODO: Display deposit-only entries.
                        continue;
                    } else if (ledgerInput.equalsIgnoreCase("P")) {
                        System.out.println("Displaying all payments...");
                        // TODO: Display payment-only entries.
                        continue;
                    } else if (ledgerInput.equalsIgnoreCase("R")) {
                        // Enter Report Screen: another inner loop
                        String reportInput = "";
                        while (!reportInput.equals("6")) {
                            Screens.reportScreen();  // Display report menu
                            System.out.print("Enter a report option: ");
                            reportInput = sc.nextLine().trim();

                            if (reportInput.equals("1")) {
                                System.out.println("Month To Date Report...");
                                // TODO: Display Month To Date report.
                                continue;
                            } else if (reportInput.equals("2")) {
                                System.out.println("Previous Month Report...");
                                // TODO: Display Previous Month report.
                                continue;
                            } else if (reportInput.equals("3")) {
                                System.out.println("Year To Date Report...");
                                // TODO: Display Year To Date report.
                                continue;
                            } else if (reportInput.equals("4")) {
                                System.out.println("Previous Year Report...");
                                // TODO: Display Previous Year report.
                                continue;
                            } else if (reportInput.equals("5")) {
                                System.out.println("Search by Vendor...");
                                // TODO: Prompt user for vendor name and display relevant entries.
                                continue;
                            } else if (reportInput.equals("6")) {
                                System.out.println("Returning to Ledger Screen...\n");
                                break;  // Exit the report loop back to the ledger screen.
                            } else if (reportInput.equals("0")) {
                                System.out.println("Exiting application. Goodbye!");
                                return;  // Exit the entire application.
                            } else {
                                System.out.printf("You entered an invalid report option: %s. Please try again!\n", reportInput);
                            }
                        }
                        // After exiting the report loop, continue with the ledger loop.
                        continue;
                    } else if (ledgerInput.equalsIgnoreCase("X")) {
                        System.out.println("Exiting application. Goodbye!");
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
