package Potroha;

import static Potroha.Driver.driver;

import java.util.ArrayList;

public class Tab_Switch {
    public static void tab_switch(int tab_num) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab_num));
    }
}

