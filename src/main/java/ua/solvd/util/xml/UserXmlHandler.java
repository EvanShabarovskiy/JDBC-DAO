package ua.solvd.util.xml;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import ua.solvd.entity.User;
import java.util.ArrayList;
import java.util.List;

public class UserXmlHandler extends DefaultHandler {
    @Getter
    private final List<User> users = new ArrayList<>();
    private User currentUser;
    private final StringBuilder elementValue = new StringBuilder();

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {
        elementValue.setLength(0);
        if ("user".equals(qName)) { currentUser = new User(); }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        elementValue.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String lName, String qName) {
        if (currentUser == null) return;
        String value = elementValue.toString().trim();

        switch (qName) {
            case "id" -> currentUser.setId(Integer.parseInt(value));
            case "email" -> currentUser.setEmail(elementValue.toString().trim());
            case "passwordHash" -> currentUser.setPasswordHash(elementValue.toString().trim());
            case "phone" -> currentUser.setPhone(elementValue.toString().trim());
            case "roleId" -> currentUser.setRoleId(Integer.parseInt(value));
            case "user" -> {
                users.add(currentUser);
                currentUser = null;
            }
        }
    }
}