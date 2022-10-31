package Selectors.Stage.Property;


public class CHAPTER_Edit_Property {

    public static String BUTTON_Send_Notifications = "//a[contains(text(),'Send Notifications')]";
    public static String SELECT_LIST_New_Deal_Notification = "//option[contains(text(),'New Deal Notification')]";
    public static String SELECT_LIST_Price_Reduced_Notification = "//option[contains(text(),'Price Reduced Notification')]";
    public static String BUTTON_Send_New_Deal_Notifications = "//span[contains(text(),'Send New Deal Notifications')]";
    public static String BUTTON_Send_Price_Reduced_Notifications = "//span[contains(text(),'Send Price Reduced Notifications')]";


    public static String CHAPTER_Photos_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/images']";
    }
    public static String CHAPTER_Videos_by_num(int num) {
        return "//a[@href='/properties/"+num+"/videos']";
    }
    public static String CHAPTER_Matterport_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/matterport']";
    }
    public static String CHAPTER_Documents_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/documents']";
    }
    public static String CHAPTER_Open_Houses_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/open-houses']";
    }
    public static String CHAPTER_Notes_by_num(int num) {
        return "//a[@href='/properties/"+num+"/notes']";
    }
    public static String CHAPTER_Inquiries_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/inquiries']";
    }
    public static String CHAPTER_Address_Requests_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/adress-requests']";
    }
    public static String CHAPTER_Offers_by_num(int num) {
        return "//a[@href='/properties/"+num+"/offers']";
    }
    public static String CHAPTER_Comps_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/comparables']";
    }
    public static String CHAPTER_God_Mode_by_num(int num) {
        return "//a[@href='/properties/"+num+"/flips']";
    }
    public static String CHAPTER_AI_Buyers_by_num(int num) {
    	return "//a[@href='/properties/"+num+"/ai-buyers']";
    }
}
