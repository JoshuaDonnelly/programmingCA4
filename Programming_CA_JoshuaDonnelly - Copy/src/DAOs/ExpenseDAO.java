package DAOs;

import DTOs.ExpenseDTO;

import java.sql.*;

public class ExpenseDAO {
    private Connection connection;

    public ExpenseDAO(Connection connection) {
        this.connection = connection;
    }
    public void listExpenses() {
        String query = "SELECT * FROM expense";
        double totalSpend = 0;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("expenseID");
                String title = rs.getString("title");
                String category = rs.getString("category");
                double amount = rs.getDouble("amount");
                String date = rs.getString("dateIncurred");

                System.out.println(id + ". " + title + " (" + category + ") - €" + amount + " on " + date);
                totalSpend += amount;
            }
            System.out.println("Total Spend: €" + totalSpend);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addExpense (ExpenseDTO expense) throws SQLException {
        String addExpSQl = "INSERT INTO expense (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
        PreparedStatement ps1 = this.connection.prepareStatement(addExpSQl);
        ps1.setString(1, expense.getTitle());
        ps1.setString(2, expense.getCategory());
        ps1.setInt(3, expense.getAmount());
        ps1.setString(4, expense.getDateIncurred());
        ps1.executeUpdate();
    }

    //delete an expense
    public void deleteExpense (int id) throws SQLException {
        String sql = "DELETE FROM expense WHERE expenseID = ?";
        PreparedStatement ps1 = this.connection.prepareStatement(sql);
        ps1.setInt(1, id);
        ps1.executeUpdate();
    }
    //calculate totals
    public double calculateTotalExpenses () throws SQLException {
        String sql = "SELECT SUM(amount) FROM expense";
        try (PreparedStatement ps1 = this.connection.prepareStatement(sql)) {
            ResultSet rs = ps1.executeQuery();
            return rs.next() ? rs.getDouble(1) : 0;
        }

    }
}

