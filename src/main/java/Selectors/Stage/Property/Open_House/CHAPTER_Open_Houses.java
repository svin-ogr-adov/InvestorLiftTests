package Selectors.Stage.Property.Open_House;


public class CHAPTER_Open_Houses {
    public static String FIELD_Date = "//input[@placeholder='DD/MM/YYYY']";
    public static String FIELDS_Time = "//div[@class='vdatetime']";
    public static String FIELD_Time_From = "/html/body/div[1]/div[2]/form/div[1]/div[2]/div/div/input";
    public static String FIELD_Time_To = "/html/body/div[1]/div[2]/form/div[1]/div[3]/div/div/input";
    public static String BUTTON_Create_Open_House = "//*[contains(text(),'Create Open House')]";
    public static String BUTTON_FORM_Close = "//*[text()='Close']";
    public static String BUTTON_Select_Buyer = "//*[contains(text(),'Select Buyer...')]";
    public static String BUTTON_Add_Buyer = "//span[contains(text(),'Add Buyer')]";
    public static String BUTTON_Send_Notifications = "//a[contains(text(),'Send Notifications')]";
    public static String BUTTON_Cancel_Open_House = "//span[contains(text(),'Cancel Open')]";
    public static String BUTTON_Remove_Open_House = "//*[contains(text(),'Remove Open House')]";
    public static String LINK_Random_Open_House = "//div[@class='open-house-link']";
    public static String[] FORM_Time_Selectors(String state, String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String[] result = new String[4];
        String from_to = state == "from" ? "2" : "3";
        if (hours < 12) {
            result[2] = "/html/body/div[1]/div[2]/form/div[1]/div["
                    +from_to+"]/div/div/div/div[2]/div[2]/div/div[3]/div[1]";
        } else {
            result[2] = "/html/body/div[1]/div[2]/form/div[1]/div["
                    +from_to+"]/div/div/div/div[2]/div[2]/div/div[3]/div[2]";
        }
        hours = hours > 12 ? hours-12 : hours;
        if (hours == 12) {
            result[0] = "/html/body/div[1]/div[2]/form/div[1]/div["
                    +from_to+"]/div/div/div/div[2]/div[2]/div/div[1]/div[1]";
        } else {
            result[0] = "/html/body/div[1]/div[2]/form/div[1]/div["
                    +from_to+"]/div/div/div/div[2]/div[2]/div/div[1]/div[" +(hours+1)+"]";
        }
        result[1] = "/html/body/div[1]/div[2]/form/div[1]/div["
                +from_to+"]/div/div/div/div[2]/div[2]/div/div[2]/div["+(minutes+1)+"]";
        result[3] = "/html/body/div[1]/div[2]/form/div[1]/div["
                +from_to+"]/div/div/div/div[2]/div[3]/div[2]";

        return result;
    }
}
