package Selectors.Stage;

public class PAGE_Create_New_Property {
    static public String FIELD_Title = "//*[@name='title']";
    static public String FIELD_Description = "//*[@class='ql-editor ql-blank']";
    public static class DROP_DOWN_Status {
        static public String DROP_DOWN_Status = "//*[@class='form-control status-select']";
        static public String Draft = "//*[@value='draft']";
        static public String Available = "//*[@value='available']";
        static public String Sold = "//*[@value='sold']";
        static public String Pending = "//*[@value='pending']";
        static public String Dead = "//*[@value='dead']";
    }
}
