package ua.solvd;

import ua.solvd.controller.OrderController;
import ua.solvd.controller.UserController;
import ua.solvd.entity.Partner;
import ua.solvd.entity.User;
import ua.solvd.service.json.JacksonService;
import ua.solvd.service.xml.JaxbPartnerService;
import ua.solvd.service.xml.UserXmlService;
import ua.solvd.util.EmailGenerator;

import java.math.BigDecimal;
import java.util.List;

public class Main 
{
    public static void main( String[] args ) {
        UserController userController = new UserController();
        userController.registerNewUser();

        OrderController orderController = new OrderController();
        orderController.checkout();

        UserXmlService xmlService = new UserXmlService();
        System.out.println("=== STEP 1: Reading existing users from XML ===");
        List<User> users = xmlService.getAllUsers();
        users.forEach(user -> System.out.println("Found in XML: " + user.getEmail()));

        System.out.println("\n=== STEP 2: Adding a new user in XML ===");
        int newId = users.size() + 1;
        User newUser = new User(newId, EmailGenerator.generateUniqueEmail(), "pass123", "000-000", 1);

        users.add(newUser);
        xmlService.saveAllUsers(users);
        System.out.println("User " + newUser.getEmail() + "successfully added to file!");

        System.out.println("\n=== STEP 3: Recheck ===");
        List<User> updatedUsers = xmlService.getAllUsers();
        System.out.println("The total number of users in the file is now: " + updatedUsers.size());
        updatedUsers.forEach(u -> System.out.println("- " + u.getEmail()));

        Partner myPartner = new Partner(1, "Golden Dragon", 10, 20, new BigDecimal("4.85"), true);

        new JaxbPartnerService().executeDemo(myPartner);

        new JacksonService().executeDemo(myPartner);
    }
}
