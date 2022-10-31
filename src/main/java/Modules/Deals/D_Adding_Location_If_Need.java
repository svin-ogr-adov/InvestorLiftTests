package Modules.Deals;

import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elems;

import org.openqa.selenium.Keys;

import Data.Buyers;
import Potroha.Collector;
import Potroha.Wait;
import Selectors.Deals.PAGE_Register;

public class D_Adding_Location_If_Need {
    public static void d_adding_location_if_need() {
        try {
            Thread.sleep(1000);
            Wait.off_implicit_wait();
            if (elems(PAGE_Register.TEXT_Add_location).size() > 0) {
            	System.out.println("LOCATION!");
                elem(PAGE_Register.Additional.FIELD_Add_Location).sendKeys(Buyers.jesus.location);
                Thread.sleep(1000);
                elem(PAGE_Register.Additional.FIELD_Add_Location).click();
                elem(PAGE_Register.Additional.FIELD_Add_Location).sendKeys(Keys.ARROW_DOWN);
                elem(PAGE_Register.Additional.FIELD_Add_Location).sendKeys(Keys.ENTER);
                Thread.sleep(1000);
                elem(PAGE_Register.Additional.BUTTON_Add_Location).click();
                elem(PAGE_Register.Additional.BUTTON_Save_and_continue).click();
            }
            Wait.on_implicit_wait();
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
