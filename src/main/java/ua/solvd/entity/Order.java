package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data @NoArgsConstructor @AllArgsConstructor
public class Order {
    private Integer id;
    private Integer customerId;
    private Integer partnerId;
    private Integer courierId;
    private Integer addressId;
    private Integer statusId;
    private BigDecimal totalPrice;
    private BigDecimal deliveryFee;
    private Timestamp createdAt;
}