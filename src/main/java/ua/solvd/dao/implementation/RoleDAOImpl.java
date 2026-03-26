package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Role;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class RoleDAOImpl implements BaseDAO<Role, Integer> {
    @Override
    public void create(Role role) {
        String sql = "INSERT INTO Roles (name) VALUES (?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, role.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) role.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating role", e);
        }
    }
    @Override public Optional<Role> findById(Integer id) { return Optional.empty(); }
    @Override public List<Role> findAll() { return Collections.emptyList(); }
    @Override public void update(Role entity) {}
    @Override public void delete(Integer id) {}
}
