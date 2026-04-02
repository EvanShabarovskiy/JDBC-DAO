package ua.solvd.entity;
import lombok.*;
import jakarta.xml.bind.annotation.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name = "partner")
@XmlAccessorType(XmlAccessType.FIELD)
public class Partner {
    private Integer id;
    private String name;
    private Integer categoryId;
    private Integer addressId;
    private BigDecimal rating;
    private boolean isActive;
}
