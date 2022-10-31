package Potroha;

import static Potroha.Driver.driver;

import java.util.ArrayList;

public class All_Tabs_Close {
    public static void all_tabs_close() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }
}
