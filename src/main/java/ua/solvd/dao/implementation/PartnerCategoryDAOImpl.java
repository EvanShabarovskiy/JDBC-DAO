package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.PartnerCategory;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class PartnerCategoryDAOImpl implements BaseDAO<PartnerCategory, Integer> {
    @Override
    public void create(PartnerCategory category) {
        String sql = "INSERT INTO PartnerCategories (name) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, category.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) category.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating partner category", e);
        }
    }
    @Override public Optional<PartnerCategory> findById(Integer id) { return Optional.empty(); }
    @Override public List<PartnerCategory> findAll() { return Collections.emptyList(); }
    @Override public void update(PartnerCategory entity) {}
    @Override public void delete(Integer id) {}
}
