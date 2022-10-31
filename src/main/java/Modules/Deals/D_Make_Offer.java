package Modules.Deals;

import static Potroha.Driver.driver;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;

import org.openqa.selenium.JavascriptExecutor;

import Data.Buyers;
import Data.New_Offer_Info;
import Mail.Sent_Event;
import Potroha.Collector;
import Selectors.Deals.FORM_Offer;
import Selectors.Deals.PAGE_Property;

public class D_Make_Offer {
    public static void d_make_offer() {
        try {
            elem_wait(PAGE_Property.BUTTON_Make_an_Offer, 500, 6).click();
            elem_wait(FORM_Offer.FIELD_Offer_Amount, 100, 20).sendKeys(New_Offer_Info.Offer_Amount);
            elem(FORM_Offer.FIELD_EMD_Amount).sendKeys(New_Offer_Info.EMD_Amount);
            elem(FORM_Offer.FIELD_Buyer_Company).sendKeys(Buyers.jesus.buyer_company);
            elem(FORM_Offer.BUTTON_Make_an_Offer).click();
            Collector.add_event(new Sent_Event("Your offer was received"));
            elem_wait(FORM_Offer.TEXT_Almost_there, 100, 20);
            JavascriptExecutor js = driver;
            js.executeScript("document.querySelector('#proof_file').style.opacity = '1'");
            js.executeScript("document.querySelector('#proof_file').style.position = 'initial'");
            js.executeScript("document.querySelector('#proof_file').style.width = '500px'");
            js.executeScript("document.querySelector('#proof_file').style.height = '45px'");
            elem(FORM_Offer.INPUT).sendKeys(New_Offer_Info.PATH_PDF_Proof_of_Funds);
            elem_wait(FORM_Offer.BUTTON_Confirm_Proof_of_Funds, 100, 20).click();
            elem_wait(FORM_Offer.BUTTON_Confirm, 100, 20).click();
            Collector.add_event(new Sent_Event("Proof of Funds Received"));
            elem_wait(FORM_Offer.BUTTON_Close, 100, 20).click();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
