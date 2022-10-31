package Modules.Deals;
import static Modules.Deals.D_Adding_Location_If_Need.d_adding_location_if_need;
import static Potroha.Driver.driver;
import static Potroha.Wait.off_implicit_wait;
import static Potroha.Wait.on_implicit_wait;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;

import Data.Buyers;
import Potroha.Collector;
import Selectors.Deals.PAGE_Login;
import Selectors.Deals.PAGE_Main;

public class D_Login {
    public static boolean d_login() {
        try {
            elem_wait(PAGE_Main.TEXT_Log_In, 200, 20);
            off_implicit_wait();
            elem(PAGE_Main.BUTTON_Log_In).click();
            on_implicit_wait();
            elem(PAGE_Login.FIELD_Email_Address).sendKeys(Buyers.jesus.email_address);
            elem(PAGE_Login.FIELD_Password).sendKeys(Buyers.jesus.password);
            elem(PAGE_Login.BUTTON_Log_in).click();
            Thread.sleep(3000);
            off_implicit_wait();
            try {
                boolean err1 = elem(PAGE_Login.POPUP_Error_Message).isDisplayed();
                boolean err2 = elem(PAGE_Login.Error_Message).isDisplayed();
                if (err1 || err2) {
                    return false;
                }
            }catch (Exception e){}
            on_implicit_wait();
            d_adding_location_if_need();
            Thread.sleep(2000);
            driver.navigate().refresh();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
        return true;
    }
}
