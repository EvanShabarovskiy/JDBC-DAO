package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Partner;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class PartnerDAOImpl implements BaseDAO<Partner, Integer> {
    @Override
    public void create(Partner partner) {
        String sql = "INSERT INTO Partners (name, category_id, address_id, rating, is_active) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, partner.getName());
            ps.setObject(2, partner.getCategoryId());
            ps.setObject(3, partner.getAddressId());
            ps.setBigDecimal(4, partner.getRating());
            ps.setBoolean(5, partner.isActive());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) partner.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating partner", e);
        }
    }
    @Override public Optional<Partner> findById(Integer id) { return Optional.empty(); }
    @Override public List<Partner> findAll() { return Collections.emptyList(); }
    @Override public void update(Partner entity) {}
    @Override public void delete(Integer id) {}
}
