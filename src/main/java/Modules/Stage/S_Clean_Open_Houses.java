package Modules.Stage;

import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elems;

import java.util.List;

import org.openqa.selenium.WebElement;

import Potroha.Collector;
import Potroha.Wait;
import Selectors.Stage.PAGE_Main;
import Selectors.Stage.PAGE_Properties;
import Selectors.Stage.Property.CHAPTER_Edit_Property;
import Selectors.Stage.Property.Open_House.CHAPTER_Open_Houses;
import Selectors.Stage.Property.Open_House.FORM_Cancel_Open_House;
import Selectors.Stage.Property.Open_House.FORM_Remove_Open_House;

// removes (and cancel if need) all Open Houses in given property
public class S_Clean_Open_Houses {
    public static void s_clean_open_houses(int Property) {
        try {
            elem(PAGE_Main.CHAPTER_Properties).click();
            elem(PAGE_Properties.Property_by_num(Property)).click();
            elem(CHAPTER_Edit_Property.CHAPTER_Open_Houses_by_num(Property)).click();

            Thread.sleep(1000);
            Wait.off_implicit_wait();
            List<WebElement> Properties = elems(CHAPTER_Open_Houses.LINK_Random_Open_House);
            Wait.on_implicit_wait();

            while (Properties.size() > 0) {
                Properties.get(0).click();

                Thread.sleep(1000);
                Wait.off_implicit_wait();
                List<WebElement> cancel_button = elems(CHAPTER_Open_Houses.BUTTON_Cancel_Open_House);
                Wait.on_implicit_wait();

                if (cancel_button.size() > 0) {
                    elem(CHAPTER_Open_Houses.BUTTON_Cancel_Open_House).click();
                    elem(FORM_Cancel_Open_House.BUTTON_Confirm).click();
                }
                Thread.sleep(1000);
                elem(CHAPTER_Open_Houses.BUTTON_Remove_Open_House).click();
                elem(FORM_Remove_Open_House.BUTTON_Confirm).click();

                Thread.sleep(1000);
                Wait.off_implicit_wait();
                Properties = elems(CHAPTER_Open_Houses.LINK_Random_Open_House);
                Wait.on_implicit_wait();
            }
            //Collector.ok.add(total_open_houses_to_del + " of " + deleted_open_houses + " Open House" + (deleted_open_houses == 1 ? "" : "s") + " was deleted");
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
