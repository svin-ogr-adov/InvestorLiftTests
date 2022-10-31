package Selectors.Stage;

public class PAGE_Properties {
    public static String Property_by_num(int num) {
        return "//a[@href='/properties/"+num+"/edit']";
    }
    public static String BUTTOM_Create_Property = "//*[@href='/properties/create']";
}
