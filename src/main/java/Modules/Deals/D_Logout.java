package Modules.Deals;

import static Potroha.Web_Element.elem;

import Potroha.Collector;

public class D_Logout {
    public static void d_logout() {
        try {
            elem(Selectors.Deals.PAGE_Main.BUTTON_Current_User).click();
            elem(Selectors.Deals.PAGE_Main.BUTTON_Logout).click();
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
