package DTOs;

public class IncomeDTO {
    private int income_ID;
    private String title;
    private double amount;
    private String dateEarned;  // Format: YYYY-MM-DD

    public IncomeDTO(int income_ID, String title, double amount, String dateEarned) {
        this.income_ID = income_ID;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }
    //getters and setters
    public int getIncome_ID() {
        return income_ID;
    }

    public void setIncome_ID(int income_ID) {
        this.income_ID = income_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }
}
