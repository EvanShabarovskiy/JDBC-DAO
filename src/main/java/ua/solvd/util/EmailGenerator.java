package ua.solvd.util;

import ua.solvd.dao.implementation.UserDAOImpl;
import ua.solvd.entity.User;
import java.util.List;
import java.util.UUID;

public class EmailGenerator {
    private static final UserDAOImpl userDAO = new UserDAOImpl();

    public static String generateUniqueEmail() {
        List<User> existingUsers = userDAO.findAll();
        String newEmail;
        boolean isDuplicate;

        do {
            String randomPart = UUID.randomUUID().toString().substring(0, 8);
            newEmail = "random_email_" + randomPart + "@test.com";

            String finalNewEmail = newEmail;
            isDuplicate = existingUsers.stream()
                    .anyMatch(u -> u.getEmail().equalsIgnoreCase(finalNewEmail));

        } while (isDuplicate);

        return newEmail;
    }
}