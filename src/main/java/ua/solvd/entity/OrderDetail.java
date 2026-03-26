package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderDetail {
    private Integer id;
    private Integer orderId;
    private Integer menuItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
}
