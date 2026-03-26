package ua.solvd.service;

import ua.solvd.dao.implementation.PaymentDAOImpl;
import ua.solvd.entity.Payment;
import java.math.BigDecimal;

public class PaymentService {
    private final PaymentDAOImpl paymentDAO = new PaymentDAOImpl();

    public void processPayment(Integer orderId, Integer methodId, BigDecimal amount) {
        Payment payment = new Payment(null, orderId, methodId, amount, "COMPLETED");
        paymentDAO.create(payment);
        System.out.println("Service: Payment of " + amount + " for order " + orderId + " processed.");
    }
}