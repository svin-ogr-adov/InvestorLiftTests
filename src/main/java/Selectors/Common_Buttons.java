package Selectors;


public class Common_Buttons {
    public static String Page_by_num(int page_num){
        return "//*[@aria-posinset='"+page_num+"']";
    }
    public static String All_Page_Buttons_both_up_and_down = "//*[@aria-posinset]";
}
