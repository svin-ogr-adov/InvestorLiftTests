package Selectors.Deals;

public class PAGE_Login {
    static public String FIELD_Email_Address = "//*[@type='email']";
    static public String FIELD_Password = "//*[@type='password']";
    static public String BUTTON_Log_in = "//*[@type='submit']";

    // selector for both password fields "//*[@type='password']"
    public static class Additional {
        static public String FIELD_Add_Location = "//*[@placeholder='Select State/County/City']";
        static public String BUTTON_Add_Location = "//*[@type='submit']";
        static public String BUTTON_Close = "//*[@class='button fullwidth']";
    }
    static public String POPUP_Error_Message = "//div[contains(text(),'Wrong credentials')]";
    static public String Error_Message = "//p[contains(text(),'Wrong credentials')]";

}
