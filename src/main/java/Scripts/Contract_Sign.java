package Scripts;

import static Modules.Deals.D_Login.d_login;
import static Modules.Deals.D_Make_Offer.d_make_offer;
import static Modules.Deals.D_Register.d_register;
import static Modules.Signing_Contract.signing_contract;
import static Modules.Stage.S_Impersonate.s_impersonate;
import static Modules.Stage.S_Offer_Accept.s_offer_accept;
import static Modules.Stage.S_Offers_Clean.s_offers_clean;
import static Potroha.Driver.driver;
import static Potroha.Tab_Switch.tab_switch;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;
import static Potroha.Web_Element.elems;

import Modules.Signing_Contract.place;
import Modules.Stage.S_Login;
import Potroha.Collector;
import Potroha.Wait;
import Selectors.Deals.FORM_Offer;
import Selectors.Deals.PAGE_Main;
import Selectors.Deals.PAGE_Property;
import Selectors.Stage.PAGE_Offers;


public class Contract_Sign {
    public static void contract_sign(int user_id) {

        try {
        	S_Login.s_login();
            s_impersonate(user_id);
            Thread.sleep(3000);

            elem(Selectors.Stage.PAGE_Main.CHAPTER_Offers).click();

            s_offers_clean();

            elem(Selectors.Stage.PAGE_Main.BUTTON_Deals_site).click();
            tab_switch(1);

            if (!d_login()) d_register();

            elem_wait(PAGE_Main.Properties,500, 20).click();

            d_make_offer();

            tab_switch(0);
            Thread.sleep(3000);
            elem(Selectors.Stage.PAGE_Main.CHAPTER_Offers).click();

            s_offer_accept();

            tab_switch(1);

            elem(PAGE_Property.BUTTON_Complete_Offer).click();
            Thread.sleep(1000);

            Wait.off_implicit_wait();
            while (elems(FORM_Offer.BUTTON_Sign_the_Purchase_Contract_Online).size() == 0) {
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
            Wait.on_implicit_wait();

            elem(FORM_Offer.BUTTON_Sign_the_Purchase_Contract_Online).click();
            signing_contract(place.on_deals);
            tab_switch(0);
            driver.navigate().refresh();
            Wait.off_implicit_wait();
            while (elems(PAGE_Offers.BUTTONS_Sign_Contract).size() == 0) {
                driver.navigate().refresh();
                Thread.sleep(2000);
            }
            Wait.on_implicit_wait();
            elem(PAGE_Offers.BUTTONS_Sign_Contract).click();
            signing_contract(place.on_stage);
            Thread.sleep(1000);

            driver.navigate().refresh();
            Thread.sleep(3000);
            elem_wait(PAGE_Offers.BUTTONS_Download_Contract, 200, 40).click();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
