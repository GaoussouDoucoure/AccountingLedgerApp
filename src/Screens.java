public class Screens {
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
                5 - Search by Vendor
                6 - Go back to Ledger Screen
                0 - Exit the Application
                """);
    }
}
