package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Payment;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class PaymentDAOImpl implements BaseDAO<Payment, Integer> {
    @Override
    public void create(Payment payment) {
        String sql = "INSERT INTO Payments (order_id, method_id, amount, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, payment.getOrderId());
            ps.setObject(2, payment.getMethodId());
            ps.setBigDecimal(3, payment.getAmount());
            ps.setString(4, payment.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating payment", e);
        }
    }
    @Override public Optional<Payment> findById(Integer id) { return Optional.empty(); }
    @Override public List<Payment> findAll() { return Collections.emptyList(); }
    @Override public void update(Payment entity) {}
    @Override public void delete(Integer id) {}
}
