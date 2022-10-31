package Modules.Stage;

import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elems;

import Potroha.Collector;
import Selectors.Stage.PAGE_Main;

public class S_Logout {
    static public void s_logout(){
        try{
            while (elems(PAGE_Main.ELEMENT_User_Name).size() > 0)
            {
                elem(PAGE_Main.BUTTON_Logout).click();
            }
            elem(PAGE_Main.BUTTON_Logout).click();
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
