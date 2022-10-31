package Modules.Stage;

import static Potroha.Web_Element.elem;

import Potroha.Collector;
import Selectors.Stage.PAGE_Main;
import Selectors.Stage.PAGE_Properties;

public class S_Create_Property {
    public static void s_create_property() {
        try {
            elem(PAGE_Main.CHAPTER_Properties).click();
            elem(PAGE_Properties.BUTTOM_Create_Property).click();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}