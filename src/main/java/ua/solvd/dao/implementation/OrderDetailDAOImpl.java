package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.OrderDetail;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class OrderDetailDAOImpl implements BaseDAO<OrderDetail, Integer> {
    @Override
    public void create(OrderDetail detail) {
        String sql = "INSERT INTO OrderDetails (order_id, menu_item_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, detail.getOrderId());
            ps.setInt(2, detail.getMenuItemId());
            ps.setInt(3, detail.getQuantity());
            ps.setBigDecimal(4, detail.getUnitPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding order detail", e);
        }
    }

    @Override public Optional<OrderDetail> findById(Integer id) { return Optional.empty(); }
    @Override public List<OrderDetail> findAll() { return Collections.emptyList(); }
    @Override public void update(OrderDetail entity) {}
    @Override public void delete(Integer id) {}
}