package ua.solvd.service;

import ua.solvd.dao.implementation.CourierDAOImpl;
import ua.solvd.entity.Courier;
import java.math.BigDecimal;

public class CourierService {
    private final CourierDAOImpl courierDAO = new CourierDAOImpl();

    public void registerCourier(Integer userId, Integer transportTypeId) {
        Courier courier = new Courier(null, userId, transportTypeId, BigDecimal.ZERO, BigDecimal.ZERO, true);
        courierDAO.create(courier);
        System.out.println("Service: Courier registered for user ID " + userId);
    }
}