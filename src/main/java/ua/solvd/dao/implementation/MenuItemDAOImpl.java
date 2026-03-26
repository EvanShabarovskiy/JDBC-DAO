package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.MenuItem;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class MenuItemDAOImpl implements BaseDAO<MenuItem, Integer> {
    @Override
    public void create(MenuItem item) {
        String sql = "INSERT INTO MenuItems (partner_id, name, description, price, is_available) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, item.getPartnerId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setBigDecimal(4, item.getPrice());
            ps.setBoolean(5, item.isAvailable());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) item.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating menu item", e);
        }
    }
    @Override public Optional<MenuItem> findById(Integer id) { return Optional.empty(); }
    @Override public List<MenuItem> findAll() { return Collections.emptyList(); }
    @Override public void update(MenuItem entity) {}
    @Override public void delete(Integer id) {}
}
