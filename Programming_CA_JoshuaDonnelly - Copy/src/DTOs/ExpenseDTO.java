package DTOs;

import java.util.Date;

public class ExpenseDTO {
    private int expense_id;
    private String title;
    private String category;
    private int amount;
    private String dateIncurred; //year month date

    public ExpenseDTO(int expense_id, String title, String category, int amount, String dateIncurred) {
        this.expense_id = expense_id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }
    //getters and setters
    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(String dateIncurred) {
        this.dateIncurred = dateIncurred;
    }
}