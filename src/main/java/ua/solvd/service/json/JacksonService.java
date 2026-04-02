package ua.solvd.service.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import ua.solvd.entity.Partner;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JacksonService {
    private final ObjectMapper mapper = new ObjectMapper();

    public void saveToJson(Partner newPartner, String path) throws Exception {
        File file = new File(path);
        List<Partner> partners = new ArrayList<>();

        if (file.exists() && file.length() > 0) { partners = readAllFromJson(path); }

        partners.add(newPartner);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, partners);
    }

    public List<Partner> readAllFromJson(String path) throws Exception {
        File file = new File(path);
        if (!file.exists() || file.length() == 0) { return new ArrayList<>(); }
        CollectionType listType = mapper.getTypeFactory()
                .constructCollectionType(List.class, Partner.class);

        return mapper.readValue(file, listType);
    }

    public void executeDemo(Partner partner) {
        try {
            String jsonPath = "src/main/resources/json/partner.json";

            Files.createDirectories(Paths.get("src/main/resources/json"));

            saveToJson(partner, jsonPath);
            System.out.println("[Jackson] Partner saved to JSON list.");

            List<Partner> allPartners = readAllFromJson(jsonPath);
            System.out.println("[Jackson] Total partners in JSON: " + allPartners.size());

            Partner lastPartner = allPartners.get(allPartners.size() - 1);
            System.out.println("[Jackson] Last recovered: " + lastPartner.getName());

        } catch (Exception e) {
            System.err.println("[Jackson] Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}