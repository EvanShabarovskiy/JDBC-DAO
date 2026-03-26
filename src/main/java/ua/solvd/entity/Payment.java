package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class Payment {
    private Integer id;
    private Integer orderId;
    private Integer methodId;
    private BigDecimal amount;
    private String status;
}
