package Potroha;

import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;
import static Potroha.Web_Element.elems;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import Selectors.Common_Buttons;
import Selectors.Stage.Users.CHAPTER_Users;


public class Common {
    public static List<WebElement> BUTTONS_All_Pages() {
        List<WebElement> result = new ArrayList<>();
        try {
            String xpath_pages = Common_Buttons.All_Page_Buttons_both_up_and_down;
            // --- for awaiting ---
//        try{
//            driver.findElements(By.xpath(xpath_pages)).get(0).click();
//        } catch (Exception e) {}
            // --------------------
            elem_wait(xpath_pages, 500, 20);
            List<WebElement> temp_pages = elems(xpath_pages);
            for (int i = 0; i < temp_pages.size() / 2; ++i) {
                result.add(temp_pages.get(i));
            }
            //Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            //Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            //Collector.add_event(e.getMessage(), Collector.State.exception);
        }
        return result;
    }

    public static void go_to_page(int page_num) {
        // Can list: Accounts, Users, Properties
        // Can't list: Leads
        try{
            String edit_selector = CHAPTER_Users.BUTTON_Edit_User_by_ID(page_num);
            Wait.off_implicit_wait();
            Thread.sleep(2000);
            List<WebElement> item = elems(edit_selector);
            Wait.on_implicit_wait();
            List<WebElement> page_nums = BUTTONS_All_Pages();
            for (int i = 1; i < page_nums.size() && item.size()==0; ++i) {
                page_nums.get(i).click();
                Thread.sleep(1000);
                Wait.off_implicit_wait();
                item = elems(edit_selector);
                Wait.on_implicit_wait();
            }
            //Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            //Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            //Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }

    public static void check_page_elements(Class<?> c) {
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            try {
                elem((field.get(c).toString())).isDisplayed();
            } catch (Exception e) {
                //Collector.fail.add("invalid selector: " + field.getName());
            }
        }
    }

}

