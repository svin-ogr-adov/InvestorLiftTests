package Modules.Stage;

import static Potroha.Driver.driver;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;
import static Potroha.Web_Element.elems;

import Data.Addendums;
import Mail.Sent_Event;
import Potroha.Collector;
import Potroha.Wait;
import Selectors.Stage.PAGE_Offers;
import Selectors.Stage.Offers.FORM_Offer_Accept;

public class S_Offer_Accept {
    public static void s_offer_accept() {
        try {
            Wait.off_implicit_wait();
            while(elems(PAGE_Offers.BUTTONS_Accept_Offer).size() == 0) {
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
            elems(PAGE_Offers.BUTTONS_Accept_Offer).get(0).click();
            Wait.on_implicit_wait();


            Thread.sleep(1000);
            Wait.off_implicit_wait();
            if (elems(FORM_Offer_Accept.TEXT_Specify_Settlement_Date_for_this_offer).size() > 0) {
                elem_wait(FORM_Offer_Accept.FIELD_Date, 100, 20).click();
                elem_wait(FORM_Offer_Accept.BUTTON_Ok, 100, 20).click();
            }
            if (elems(FORM_Offer_Accept.TEXT_Specify_Title_Company).size() > 0) {
                elem(FORM_Offer_Accept.LIST_ITEM_Company_Kelleher_and_Sadowsky).click();
            }
            if (elems(FORM_Offer_Accept.TEXT_Specify_Additional_Contract_Addendums).size() > 0) {
                elem(FORM_Offer_Accept.FIELD_Addendums).sendKeys(Addendums.Test_Addendums);
            }
            elem_wait(FORM_Offer_Accept.BUTTON_Set_and_Accept_Offer, 100, 20).click();
            Wait.on_implicit_wait();
            Collector.add_event(new Sent_Event("Your offer was accepted"));

                Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
            } catch (Exception e) {
                Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
                Collector.add_event(e.getMessage(), Collector.State.exception);
            }
    }
}
