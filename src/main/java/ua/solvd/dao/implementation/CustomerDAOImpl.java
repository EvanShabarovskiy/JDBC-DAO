package ua.solvd.dao.implementation;

import ua.solvd.dao.BaseDAO;
import ua.solvd.entity.Customer;
import ua.solvd.util.ConnectionManager;
import java.sql.*;
import java.util.*;

public class CustomerDAOImpl implements BaseDAO<Customer, Integer> {
    @Override
    public void create(Customer customer) {
        String sql = "INSERT INTO Customers (user_id, first_name, last_name) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getUserId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating customer", e);
        }
    }
    @Override public Optional<Customer> findById(Integer id) { return Optional.empty(); }
    @Override public List<Customer> findAll() { return Collections.emptyList(); }
    @Override public void update(Customer entity) {}
    @Override public void delete(Integer id) {}
}