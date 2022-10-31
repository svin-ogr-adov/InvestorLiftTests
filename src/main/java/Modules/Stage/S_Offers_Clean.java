package Modules.Stage;

import static Potroha.Web_Element.elem_wait;
import static Potroha.Web_Element.elems;

import Potroha.Collector;
import Potroha.Wait;
import Selectors.Stage.PAGE_Offers;
import Selectors.Stage.Offers.FORM_Delete_Offer;

public class S_Offers_Clean {
    public static void s_offers_clean() {
        try {
            Thread.sleep(2000);
            Wait.off_implicit_wait();
            int actual_size = elems(PAGE_Offers.BUTTONS_Trash_Offer).size();
            int expected_size = actual_size;
            while (actual_size > 0) {
                if (actual_size == expected_size) {
                    elems(PAGE_Offers.BUTTONS_Trash_Offer).get(0).click();
                    elem_wait(FORM_Delete_Offer.BUTTON_Confirm, 200, 20).click();
                    --actual_size;
                } else {
                    System.out.println("actual: "+actual_size+" expected: "+expected_size);
                    expected_size = elems(PAGE_Offers.BUTTONS_Trash_Offer).size();
                }
            }
            Wait.on_implicit_wait();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
