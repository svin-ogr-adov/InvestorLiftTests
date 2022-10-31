package Selectors.Stage.Users;

public class CHAPTER_Users {

        public static String FIELD_Search_by_name_or_email = "//*[@name='search']";
        public static String BUTTON_Edit_User_by_ID(int num) {
            return "//*[td="+num+"]/td/a[@title='Edit']";
        }
        public static String BUTTON_Remove_User_by_ID(int num) {
            return "//*[td="+num+"]/td/a[@title='Remove']";
        }
        public static String BUTTON_Impersonate_User_by_ID(int num) {
            return "//*[td="+num+"]/td/a[@title='Impersonate user']";
        }
}
