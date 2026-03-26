package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class Partner {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer addressId;
    private BigDecimal rating;
    private boolean isActive;
}
