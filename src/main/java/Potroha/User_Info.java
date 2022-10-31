package Potroha;

import static Potroha.Web_Element.elem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_Info {
    public static info by_id(int id) {
        info ui = new info();
        info.id = id;
        String name = elem("//td[contains(text(),'"+id+"')]/following-sibling::td[1]").getText();
        name_handle(name);
		info.name = hui.name;
        name_handle(name);
		info.email = hui.email;
        info.account = elem("//td[contains(text(),'"+id+"')]/following-sibling::td[2]").getText();
        String roles = elem("//td[contains(text(),'"+id+"')]/following-sibling::td[3]").getText();
        info.roles = parse_roles(roles);
        return  ui;
    }
    public static info by_name(String name) {
        info ui = new info();
        info.name = name;
        info.id = Integer.parseInt(elem("//td[contains(text(),'" + name + "')]/preceding::td[1]").getText());
        info.account = elem("//td[contains(text(),'" + name + "')]/following-sibling::td[1]").getText();
        String roles = elem("//td[contains(text(),'" + name + "')]/following-sibling::td[2]").getText();
        info.roles = parse_roles(roles);
        return  ui;
    }
    public static info by_account(String account) {
        info ui = new info();
        info.account = account;
        String name = elem("//td[contains(text(),'" + account + "')]/preceding::td[1]").getText();
        name_handle(name);
		info.name = hui.name;
        name_handle(name);
		info.email = hui.email;
        info.id = Integer.parseInt(elem("//td[contains(text(),'" + account + "')]/preceding::td[2]").getText());
        String roles = elem("//td[contains(text(),'" + account + "')]/following-sibling::td[1]").getText();
        info.roles = parse_roles(roles);
        return  ui;
    }
    private static List<String> parse_roles(String roles) {
        List<String> result = new ArrayList<>();
        if (Arrays.asList(roles.split(" ")).contains("Super")) {
            result.add("Super Administrator");
        }
        if (Arrays.asList(roles.split(" ")).contains("Administrator")) {
            result.add("Administrator");
        }
        if (Arrays.asList(roles.split(" ")).contains("Acquisition")) {
            result.add("Acquisition Manager");
        }
        if (Arrays.asList(roles.split(" ")).contains("Disposition")) {
            result.add("Disposition Manager");
        }
        return  result;
    }
    public static class info {
        public static int id;
        public static String name;
        public static String email;
        public static String account;
        public static List<String> roles;
    }
    public static class hui {
        public static String name;
        public static String email;
    }
    public static hui name_handle(String name) {
        hui result = new hui();
        String[] lines = name.split("[\r\n]+");
        int counter = 0;
        for (String s : lines) {
            if (counter == 0 && s !=null) {
                hui.name = s;
                ++counter;
            } else {
                hui.email = s;
            }
        }
        return result;
    }
}
