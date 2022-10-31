package Selectors.Deals;

public class PAGE_Register {
    static public String FIELD_First_Name = "//*[@placeholder='First Name']";
    static public String FIELD_Last_Name = "//*[contains(text(),'Last Name')]";
    static public String FIELD_Email_Address = "//*[@type='email']";
    static public String FIELD_Phone_Number = "//*[@name='phone']";
    static public String FIELD_Password = "//*[@tabindex='5']";
    static public String FIELD_Repeat_Password = "//*[@tabindex='6']";
    static public String BUTTON_Register = "//*[@type='submit']";
    static public String TEXT_Add_location = "//*[contains(text(),'Add location')]";
    static public String TEXT_no_locations_yet = "//td[contains(text(),'no locations yet')]";

    // selector for both password fields "//*[@type='password']"
    public static class Additional {
        static public String FIELD_Add_Location = "//*[@placeholder='Select State/County/City']";
        static public String BUTTON_Add_Location = "//*[@type='submit']";
        static public String BUTTON_Close = "//*[@class='button fullwidth']";
        static public String BUTTON_Save_and_continue = "//a[@class='button halfwidth']";
    }

}
