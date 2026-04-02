package ua.solvd.service.xml;

import jakarta.xml.bind.*;
import ua.solvd.entity.Partner;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;

public class JaxbPartnerService {

    public void saveToXml(Partner newPartner, String xmlPath, String xsdPath) throws Exception {
        JAXBContext context = JAXBContext.newInstance(PartnerListWrapper.class);
        File file = new File(xmlPath);
        PartnerListWrapper wrapper = new PartnerListWrapper();

        if (file.exists() && file.length() > 0) {
            try {
                Unmarshaller unm = context.createUnmarshaller();
                Object result = unm.unmarshal(file);
                if (result instanceof PartnerListWrapper) {
                    wrapper = (PartnerListWrapper) result;
                }
            } catch (JAXBException e) {
                System.out.println("[JAXB] File found, but empty or invalid. Starting a new list.");
            }
        }

        if (wrapper.getPartners() == null) {
            wrapper.setPartners(new ArrayList<>());
        }

        wrapper.getPartners().add(newPartner);

        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        mar.setSchema(sf.newSchema(new File(xsdPath)));

        mar.marshal(wrapper, file);
    }

    public void executeDemo(Partner partner) {
        try {
            String xsd = "src/main/java/ua/solvd/schema/partner.xsd";
            String xml = "src/main/resources/xml/partner.xml";

            saveToXml(partner, xml, xsd);
            System.out.println("[JAXB] Partner saved to XML. Total partners now: " +
                    getCountFromFile(xml));
        } catch (Exception e) {
            System.err.println("[JAXB] Error in demo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int getCountFromFile(String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(PartnerListWrapper.class);
            Unmarshaller unm = context.createUnmarshaller();
            PartnerListWrapper w = (PartnerListWrapper) unm.unmarshal(new File(path));
            return w.getPartners().size();
        } catch (Exception e) {
            return 0;
        }
    }
}