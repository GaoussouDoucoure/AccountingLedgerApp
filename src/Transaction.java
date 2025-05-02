import java.text.DecimalFormat;

public class Transaction {
    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    //Constructor
    Transaction(String date, String time, String description, String vendor, double amount){
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Getters
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getDescription(){
        return description;
    }
    public String getVendor(){
        return vendor;
    }
    public double getAmount(){
        return amount;
    }

    //Setters
    public void setDate(String date){
        this.date = date;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }

    // toString method to represent the transaction details
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        // Using fixed-width for each field:
        // %-12s for date, %-8s for time, %-25s for description, %-20s for vendor, and %10s for amount.
        return String.format("%-12s | %-8s | %-25s | %-20s | %10s",
                date,
                time,
                description,
                vendor,
                "$" + df.format(amount));
    }
}
