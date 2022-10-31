package Modules.Stage;

import static Potroha.Web_Element.elem;

import Data.Emails;
import Data.Property;
import Potroha.Collector;
import Selectors.Stage.PAGE_Main;
import Selectors.Stage.PAGE_Properties;
import Selectors.Stage.Property.CHAPTER_Edit_Property;
import Selectors.Stage.Property.FORM_Send_Notifications;

public class S_New_Deal {
    public static void s_new_deal() {
        try{
            // select property
            elem(PAGE_Main.CHAPTER_Properties).click();
            elem(PAGE_Properties.Property_by_num(Property.Property_Test_ID)).click();
            elem(CHAPTER_Edit_Property.BUTTON_Send_Notifications).click();
            elem(FORM_Send_Notifications.SELECT_LIST_New_Deal_Notification).click();
            elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
            elem(FORM_Send_Notifications.CHAPTER_Buyers_List).click();
            elem(FORM_Send_Notifications.FIELD_Search_Buyer).sendKeys(Emails.address_1.user);
            elem(FORM_Send_Notifications.SELECT_LIST_Autocomplete).click();
            elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
            Thread.sleep(1000);
            elem(FORM_Send_Notifications.BUTTON_Back).click();
            Thread.sleep(1000);
            elem(FORM_Send_Notifications.BUTTON_Back).click();
            elem(FORM_Send_Notifications.SELECT_LIST_Price_Reduced_Notification).click();
            elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
            elem(FORM_Send_Notifications.CHAPTER_Buyers_List).click();
            elem(FORM_Send_Notifications.FIELD_Search_Buyer).sendKeys(Emails.address_1.user);
            elem(FORM_Send_Notifications.SELECT_LIST_Autocomplete).click();
            elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
            elem(FORM_Send_Notifications.BUTTON_Done).click();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
