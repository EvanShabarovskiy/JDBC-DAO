package ua.solvd.controller;

import ua.solvd.service.OrderService;
import ua.solvd.util.EmailGenerator;

import java.math.BigDecimal;

public class OrderController {
    private final OrderService orderService = new OrderService();

    public void checkout() {
        String uniqueEmail = EmailGenerator.generateUniqueEmail();
        System.out.println("--- Starting E2E Flow ---");
        orderService.placeOrderFlow(uniqueEmail, "hash123", 1, 5, new BigDecimal("999.00"));
        System.out.println("--- Checkout Finished Successfully ---");
    }
}
