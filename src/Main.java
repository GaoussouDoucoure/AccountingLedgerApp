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
                Ledger screen, choose an option to proceed:
                A - Display All Entries
                D - Deposits
                P - Payments
                R - Reports
                H - Go back to Home Page
                """);
    }
    public static void main(String[] args) {

    }
}