package ua.solvd.service.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import ua.solvd.entity.User;
import ua.solvd.util.xml.UserXmlHandler;
import java.io.*;
import java.util.List;

public class UserXmlService {
    private final String FILE_PATH = "src/main/resources/xml/users.xml";

    public List<User> getAllUsers() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserXmlHandler handler = new UserXmlHandler();
            saxParser.parse(new File(FILE_PATH), handler);
            return handler.getUsers();
        } catch (Exception e) {
            throw new RuntimeException("Reading error XML: " + e.getMessage());
        }
    }

    public void saveAllUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
            writer.write("<users>\n");
            for (User u : users) {
                writer.write("    <user>\n");
                writer.write("        <id>" + u.getId() + "</id>\n");
                writer.write("        <email>" + u.getEmail() + "</email>\n");
                writer.write("        <passwordHash>" + u.getPasswordHash() + "</passwordHash>\n");
                writer.write("        <phone>" + u.getPhone() + "</phone>\n");
                writer.write("        <roleId>" + u.getRoleId() + "</roleId>\n");
                writer.write("    </user>\n");
            }
            writer.write("</users>");
        } catch (IOException e) {
            throw new RuntimeException("Writing in XML error: " + e.getMessage());
        }
    }
}