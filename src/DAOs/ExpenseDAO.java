package DAOs;

import DTOs.ExpenseDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExpenseDAO {
    private Connection connection;

    public ExpenseDAO(Connection connection) {
        this.connection = connection;
    }

    public void addExpense (ExpenseDTO expense) throws SQLException {
        String addExpSQl = "INSERT INTO expenses (title, category, amount, date_incurred, date_earned) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps1 = this.connection.prepareStatement(addExpSQl);
        ps1.setString(1, expense.getTitle());
        ps1.setString(2, expense.getCategory());
        ps1.setInt(3, expense.getAmount());
        ps1.setDate(4, (java.sql.Date) expense.getDateIncurred());
        ps1.executeUpdate();
    }
}

