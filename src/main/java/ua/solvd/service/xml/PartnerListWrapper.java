package ua.solvd.service.xml;

import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import ua.solvd.entity.Partner;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@XmlRootElement(name = "partners")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartnerListWrapper {

    @XmlElement(name = "partner")
    private List<Partner> partners = new ArrayList<>();
}