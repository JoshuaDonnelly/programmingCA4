package DAOs;

import DTOs.ExpenseDTO;
import DTOs.IncomeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
    private Connection connection;

    public IncomeDAO(Connection connection) {
        this.connection = connection;
    }
    public void listIncome() {
        String query = "SELECT * FROM income";
        double totalIncome = 0;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("incomeID");
                String title = rs.getString("title");
                double amount = rs.getDouble("amount");
                String date = rs.getString("dateEarned");

                System.out.println(id + ". " + title + " - €" + amount + " on " + date);
                totalIncome += amount;
            }
            System.out.println("Total Income: €" + totalIncome);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addIncome (IncomeDTO income) throws SQLException {
        String addExpSQl = "INSERT INTO income (title,  amount, dateEarned) VALUES (?, ?, ?)";
        PreparedStatement ps1 = this.connection.prepareStatement(addExpSQl);
        ps1.setString(1, income.getTitle());
        ps1.setDouble(2, income.getAmount());
        ps1.setString(3,  income.getDateEarned());
        ps1.executeUpdate();
    }
    //delete by ID
    public void deleteIncome (int id) throws SQLException {
        String deleteIncomeSQl = "DELETE FROM income WHERE incomeID=?";
        try (PreparedStatement ps1 = this.connection.prepareStatement(deleteIncomeSQl)) {
            ps1.setInt(1, id);
            ps1.executeUpdate();
        }

    }
    //list every income
    public List<IncomeDTO> getAllIncomes() throws SQLException {
        List<IncomeDTO> incomes = new ArrayList<>();
        String sql = "SELECT * FROM income";
        try (PreparedStatement ps = this.connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            while (rs.next()) {
                incomes.add(new IncomeDTO(
                        rs.getInt("incomeID"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getString("dateEarned")
                ));
            }
        }
        return incomes;
    }
    //calc total incomes
    public double getTotalIncome() throws SQLException {
        String sql = "SELECT SUM(amount) FROM income";
        try (PreparedStatement ps = this.connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(sql)) {
            return rs.next() ? rs.getDouble(1) : 0;
        }
    }
}




