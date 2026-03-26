package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Address;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class AddressDAOImpl implements BaseDAO<Address, Integer> {
    @Override
    public void create(Address address) {
        String sql = "INSERT INTO Addresses (city, street, house_number, latitude, longitude) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, address.getCity());
            ps.setString(2, address.getStreet());
            ps.setString(3, address.getHouseNumber());
            ps.setBigDecimal(4, address.getLatitude());
            ps.setBigDecimal(5, address.getLongitude());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) address.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating address", e);
        }
    }
    @Override public Optional<Address> findById(Integer id) { return Optional.empty(); }
    @Override public List<Address> findAll() { return Collections.emptyList(); }
    @Override public void update(Address entity) {}
    @Override public void delete(Integer id) {}
}
