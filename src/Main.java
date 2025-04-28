public class Main {
    public void homeScreen(){
        System.out.println("""
                Welcome to your Accounting Ledger App!
                Please choose an option to proceed:
                D - Add Deposit
                P - Make Payment (Debit)
                L - Ledger
                X - Exit the Application
                """);
    }
    public void ledgerScreen(){
        System.out.println("""
                Ledger Screen, choose an option to proceed:
                A - Display All Entries
                D - Deposits
                P - Payments
                R - Reports
                H - Go back to Home Page
                """);
    }
    public void reportScreen(){
        System.out.println("""
                Choose an option to filter:
                1 - Month To Date
                2 - Previous Month
                3 - Year To Date
                4 - Previous Year
                5 - Search by Vendor - prompt the user for the vendor name
                and display all entries for that vendor
                0 - Go back to Ledger Screen
                """);
    }
    public static void main(String[] args) {

    }
}