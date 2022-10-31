package Modules.Stage;

import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elems;
import static Selectors.Stage.Property.CHAPTER_Edit_Property.CHAPTER_Open_Houses_by_num;

import java.util.List;

import org.openqa.selenium.WebElement;

import Data.Emails;
import Data.Property;
import Potroha.Collector;
import Potroha.Time;
import Potroha.Wait;
import Selectors.Buyers;
import Selectors.Stage.PAGE_Main;
import Selectors.Stage.PAGE_Properties;
import Selectors.Stage.Property.FORM_Send_Notifications;
import Selectors.Stage.Property.Open_House.CHAPTER_Open_Houses;
import Selectors.Stage.Property.Open_House.FORM_Cancel_Open_House;
import Selectors.Stage.Property.Open_House.FORM_Search_Buyer;

public class S_Open_House {
        public static void s_open_house() {
            try{
                // select property
                elem(PAGE_Main.CHAPTER_Properties).click();
                elem(PAGE_Properties.Property_by_num(Property.Property_Test_ID)).click();
                // create new open house
                elem(CHAPTER_Open_Houses_by_num(Property.Property_Test_ID)).click();
                elem(CHAPTER_Open_Houses.FIELD_Date).sendKeys(Time.get_date("/"));
                List<WebElement> FIELDS_Time = elems(CHAPTER_Open_Houses.FIELDS_Time);
                FIELDS_Time.get(0).click(); // first field in list - "from"
                for (String time_selector : CHAPTER_Open_Houses.FORM_Time_Selectors("from","13:25")) {
                    elem(time_selector).click();
                }
                FIELDS_Time.get(1).click(); // second field in list - "to"
                for (String time_selector : CHAPTER_Open_Houses.FORM_Time_Selectors("to","23:00")) {
                    elem(time_selector).click();
                }
                elem(CHAPTER_Open_Houses.BUTTON_Create_Open_House).click();
                elem(CHAPTER_Open_Houses.BUTTON_FORM_Close).click();
                // adding buyer to current open house
                elem(CHAPTER_Open_Houses.BUTTON_Select_Buyer).click();
                elem(FORM_Search_Buyer.BUTTON_Search_Buyers).click();
                elem(Buyers.InvestorLiftTest).click();
                elem(FORM_Search_Buyer.BUTTON_Select_Buyer).click();
                elem(CHAPTER_Open_Houses.BUTTON_Add_Buyer).click();
                // adding buyer for New_Open_House notification
                elem(CHAPTER_Open_Houses.BUTTON_Send_Notifications).click();
                elem(FORM_Send_Notifications.SELECT_LIST_New_Open_House_Notification).click();
                elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
                elem(FORM_Send_Notifications.CHAPTER_Buyers_List).click();
                elem(FORM_Send_Notifications.FIELD_Search_Buyer).sendKeys(Emails.address_1.user);
                elem(FORM_Send_Notifications.SELECT_LIST_Autocomplete).click();
                // sent New Open House
                elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
                Thread.sleep(5000);
                Wait.off_implicit_wait();
                Thread.sleep(1000);
                elem(FORM_Send_Notifications.BUTTON_Back).click();
                Thread.sleep(1000);
                elem(FORM_Send_Notifications.BUTTON_Back).click();
                Wait.on_implicit_wait();
                elem(FORM_Send_Notifications.SELECT_LIST_Open_House_Rescheduled_Notification).click();
                elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
                elem(FORM_Send_Notifications.CHAPTER_Buyers_List).click();
                elem(FORM_Send_Notifications.FIELD_Search_Buyer).sendKeys(Emails.address_1.user);
                elem(FORM_Send_Notifications.SELECT_LIST_Autocomplete).click();
                // sent Open House Rescheduled
                elem(FORM_Send_Notifications.BUTTON_FOR_ANY_Send_Notifications).click();
                Thread.sleep(5000);
                // Mail_Info_Collaider.add_sent_event("Open House Rescheduled", Calendar.getInstance());
                elem(FORM_Send_Notifications.BUTTON_Done).click();
                // sent Open House Canceled
                elem(CHAPTER_Open_Houses.BUTTON_Cancel_Open_House).click();
                elem(FORM_Cancel_Open_House.BUTTON_Confirm).click();

                Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
            } catch (Exception e) {
                Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
                Collector.add_event(e.getMessage(), Collector.State.exception);
            }
       }
}
