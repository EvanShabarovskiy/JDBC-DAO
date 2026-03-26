package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Courier;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class CourierDAOImpl implements BaseDAO<Courier, Integer> {
    @Override
    public void create(Courier courier) {
        String sql = "INSERT INTO Couriers (user_id, transport_type_id, is_online) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, courier.getUserId());
            ps.setObject(2, courier.getTransportTypeId());
            ps.setBoolean(3, courier.isOnline());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating courier", e);
        }
    }
    @Override public Optional<Courier> findById(Integer id) { return Optional.empty(); }
    @Override public List<Courier> findAll() { return Collections.emptyList(); }
    @Override public void update(Courier entity) {}
    @Override public void delete(Integer id) {}
}
