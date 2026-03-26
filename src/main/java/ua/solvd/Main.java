package ua.solvd;

import ua.solvd.controller.OrderController;
import ua.solvd.controller.UserController;

public class Main 
{
    public static void main( String[] args ) {
        UserController userController = new UserController();
        userController.registerNewUser();

        OrderController orderController = new OrderController();
        orderController.checkout();
    }
}
