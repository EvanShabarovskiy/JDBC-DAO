package ua.solvd.entity;

import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class Courier {
    private Integer id;
    private Integer userId;
    private Integer transportTypeId;
    private BigDecimal currentLatitude;
    private BigDecimal currentLongitude;
    private boolean isOnline;
}
