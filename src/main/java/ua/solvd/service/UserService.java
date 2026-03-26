package ua.solvd.service;

import ua.solvd.dao.implementation.UserDAOImpl;
import ua.solvd.entity.User;

public class UserService {
    private final UserDAOImpl userDAO = new UserDAOImpl();

    public void registerUser(String email, String password, String phone, Integer roleId) {
        System.out.println("Service: Registering user with email: " + email);

        User user = new User(null, email, password, phone, roleId);

        userDAO.create(user);
    }
}