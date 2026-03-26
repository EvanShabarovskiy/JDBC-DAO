package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class MenuItem {
    private Integer id;
    private Integer partnerId;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
}
