package ua.solvd.service;

import ua.solvd.dao.implementation.PartnerDAOImpl;
import ua.solvd.entity.Partner;
import java.math.BigDecimal;

public class PartnerService {
    private final PartnerDAOImpl partnerDAO = new PartnerDAOImpl();

    public void addPartner(String name, Integer categoryId, Integer addressId) {
        Partner partner = new Partner(null, name, categoryId, addressId, new BigDecimal("0.0"), true);
        partnerDAO.create(partner);
        System.out.println("Service: Partner '" + name + "' added to database.");
    }
}