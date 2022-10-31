package Modules.Deals;

import static Modules.Deals.D_Adding_Location_If_Need.d_adding_location_if_need;
import static Potroha.Driver.driver;
import static Potroha.Web_Element.elem;

import Data.Buyers;
import Mail.Sent_Event;
import Potroha.Collector;
import Selectors.Deals.PAGE_Main;
import Selectors.Deals.PAGE_Register;

public class D_Register {
    public static void d_register() {
        try {
            elem(PAGE_Main.BUTTON_Register).click();
            elem(PAGE_Register.FIELD_First_Name).sendKeys(Buyers.jesus.first_name);
            elem(PAGE_Register.FIELD_Last_Name).sendKeys(Buyers.jesus.last_name);
            elem(PAGE_Register.FIELD_Email_Address).sendKeys(Buyers.jesus.email_address);
            elem(PAGE_Register.FIELD_Phone_Number).sendKeys(Buyers.jesus.phone_number);
            elem(PAGE_Register.FIELD_Password).sendKeys(Buyers.jesus.password);
            elem(PAGE_Register.FIELD_Repeat_Password).sendKeys(Buyers.jesus.password);
            elem(PAGE_Register.BUTTON_Register).click();
            Collector.add_event(new Sent_Event("Welcome to"));
            d_adding_location_if_need();
            Thread.sleep(2000);
            driver.navigate().refresh();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
