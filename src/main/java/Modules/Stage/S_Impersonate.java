package Modules.Stage;

import static Potroha.Common.go_to_page;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;
import static Selectors.Stage.Users.CHAPTER_Users.BUTTON_Impersonate_User_by_ID;

import Data.Users;
import Potroha.Collector;
import Potroha.Logger;
import Potroha.User_Info;
import Potroha.User_Info.info;
import Selectors.Stage.PAGE_Main;

public class S_Impersonate {
    public static void s_impersonate(int user_id) {
        try {
            elem(PAGE_Main.CHAPTER_Users).click();
            go_to_page(Users.User_Test_ID);
            Collector.header += Logger.log_delim.repeat(Logger.log_delim_repeat) + '\n';
            Collector.header += "Name:" + '\n';
            User_Info.by_id(user_id);
			Collector.header += info.name + '\n';
            Collector.header += "Account:" + '\n';
			Collector.header += info.account + '\n';
            Collector.header += Logger.log_delim.repeat(Logger.log_delim_repeat);
            elem_wait(BUTTON_Impersonate_User_by_ID(user_id), 500, 10).click();

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}
