package ua.solvd.entity;
import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class Address {
    private Integer id;
    private String city;
    private String street;
    private String houseNumber;
    private BigDecimal latitude;
    private BigDecimal longitude;
}