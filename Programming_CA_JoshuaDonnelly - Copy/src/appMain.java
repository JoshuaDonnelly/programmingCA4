import DAOs.ExpenseDAO;
import DAOs.IncomeDAO;
import DTOs.ExpenseDTO;
import DTOs.IncomeDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class appMain {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/"; // location of database
        String dbName = "finance";     // database name
        String userName = "root";   // default
        String password = "";

        try { Connection conn = DriverManager.getConnection(url + dbName, userName, password);
            ExpenseDAO expenseDAO = new ExpenseDAO(conn);
            IncomeDAO incomeDAO = new IncomeDAO(conn);

            // Example usage
            System.out.println("\n--Expenses--");
            //list expenses
            expenseDAO.listExpenses();
            System.out.println("\n--Income--");
            //list income
            incomeDAO.listIncome();
            //add expense
            expenseDAO.addExpense(new ExpenseDTO(0, "Groceries", "Food", 50, "2024-12-28"));
            //add income
            incomeDAO.addIncome(new IncomeDTO(0, "Freelance", 200.0, "2025-02-02"));
            //Deleting expense
            expenseDAO.addExpense(new ExpenseDTO(12, "Test to be deleted", "test", 100,"2024/12/12"));
            expenseDAO.deleteExpense(12);
            //Delete income
            incomeDAO.addIncome(new IncomeDTO (12,"income to be deleted", 10000.0, "2025/12/25"));
            incomeDAO.deleteIncome(12);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
