package Modules.Stage;

import static Potroha.Common.check_page_elements;
import static Potroha.Web_Element.elem;
import static Selectors.Stage.PAGE_Login.BUTTON_Sign_In;
import static Selectors.Stage.PAGE_Login.FIELD_Login;
import static Selectors.Stage.PAGE_Login.FIELD_Password;

import Data.Account_Admin_Stage;
import Potroha.Collector;
import Selectors.Stage.PAGE_Login;


public class S_Login {
    public static void s_login() {
        try {
            check_page_elements(PAGE_Login.class);
            elem(FIELD_Login).sendKeys(Account_Admin_Stage.Login);
            elem(FIELD_Password).sendKeys(Account_Admin_Stage.Password);
            elem(BUTTON_Sign_In).click();
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
