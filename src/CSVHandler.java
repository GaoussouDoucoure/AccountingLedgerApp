import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVHandler {
    private static final String csvFile = "transactions.csv";


     // Reader to read transactions from the CSV file
    public static ArrayList<Transaction> readTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        File file = new File(csvFile);

        if (!file.exists()) { // if file doesn't exist, can occur if I make typo on file name or path
            System.out.println("CSV file " + csvFile + " not found.");
            return transactions;
        }

        try (Scanner scanner = new Scanner(file)) {

            // Skip the header line for titles such as Date, Time, Desc, Vendor, Amount otherwise the conversion of amount will cause issue
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine(); // moving those titles to the variable header
            }
            // Read each remaining line and create a Transaction object.
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Split using the pipe character
                String[] data = line.split("\\|");

                // Check the line has all five required parts.
                if (data.length >= 5) {
                    String date = data[0].trim();
                    String time = data[1].trim();
                    String description = data[2].trim();
                    String vendor = data[3].trim();
                    double amount = Double.parseDouble(data[4].trim());

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
        return transactions;
    }


   // Writer to append a new transaction to the CSV file using the same pipe-delimited format.
    public static void writeTransaction(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            String line = String.format("%s|%s|%s|%s|%.2f",
                    transaction.getDate(),
                    transaction.getTime(),
                    transaction.getDescription(),
                    transaction.getVendor(),
                    transaction.getAmount());
            writer.write(line); // this will write the inputs
            writer.newLine();  // this should create a new empty line at the end
            System.out.println("Transaction added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

}
