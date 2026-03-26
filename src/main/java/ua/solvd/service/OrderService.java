package ua.solvd.service;

import ua.solvd.dao.implementation.*;
import ua.solvd.entity.*;
import java.math.BigDecimal;

public class OrderService {
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final OrderDAOImpl orderDAO = new OrderDAOImpl();
    private final OrderDetailDAOImpl detailDAO = new OrderDetailDAOImpl();

    public void placeOrderFlow(String email, String pass, Integer partnerId, Integer itemId, BigDecimal price) {
        User user = new User(null, email, pass, "0931234567", 1);
        userDAO.create(user);
        System.out.println("User created with ID: " + user.getId());

        Order order = new Order();
        order.setCustomerId(1);
        order.setPartnerId(partnerId);
        order.setAddressId(1);
        order.setStatusId(1);
        order.setTotalPrice(price);
        orderDAO.create(order);
        System.out.println("Order created!");

        OrderDetail detail = new OrderDetail(null, order.getId(), itemId, 1, price);
        detailDAO.create(detail);
        System.out.println("Item added to order details.");
    }
}
