package ua.solvd.controller;

import ua.solvd.service.UserService;
import ua.solvd.util.EmailGenerator;

public class UserController {
    private final UserService userService = new UserService();

    public void registerNewUser() {
        String uniqueEmail = EmailGenerator.generateUniqueEmail();
        System.out.println("--- Starting User Registration Flow ---");
        userService.registerUser(uniqueEmail, "securePass123", "0991112233", 1);
        System.out.println("--- User Registration Finished ---");
    }
}