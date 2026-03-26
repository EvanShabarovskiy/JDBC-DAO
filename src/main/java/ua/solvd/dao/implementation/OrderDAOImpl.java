package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Order;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class OrderDAOImpl implements BaseDAO<Order, Integer> {
    @Override
    public void create(Order order) {
        String sql = "INSERT INTO Orders (customer_id, partner_id, delivery_address_id, status_id, total_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getCustomerId());
            ps.setInt(2, order.getPartnerId());
            ps.setInt(3, order.getAddressId());
            ps.setInt(4, order.getStatusId());
            ps.setBigDecimal(5, order.getTotalPrice());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    order.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating order", e);
        }
    }

    @Override public Optional<Order> findById(Integer id) { return Optional.empty(); }
    @Override public List<Order> findAll() { return Collections.emptyList(); }
    @Override public void update(Order entity) {}
    @Override public void delete(Integer id) {}
}
