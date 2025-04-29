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
                0 - Go back to Ledger Screen
                """);
    }
    public static void main(String[] args) {

        homeScreen();
        ledgerScreen();
        reportScreen();
    }
}