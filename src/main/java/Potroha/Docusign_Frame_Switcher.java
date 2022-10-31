package Potroha;


import static Potroha.Driver.driver;
import static Potroha.Web_Element.elem;

import org.openqa.selenium.By;

public class Docusign_Frame_Switcher {
    public static int docusign_frame_detector(String xpath_1, String xpath_2) {
        int result = 0;
        try {
            int frames = frames_calculator();
            System.out.println("Total frames: "+frames);
            for (int i = 0; i < frames; ++i) {
            	driver.switchTo().defaultContent();
                driver.switchTo().frame(i);
                Thread.sleep(3000);
                    try {
                        Wait.off_implicit_wait();
                        if ( elem(xpath_1).isDisplayed() ||
                             elem(xpath_2).isDisplayed()) {
                            return i;
                        }
                        Wait.on_implicit_wait();
                    } catch (Exception ignored) {}
                driver.switchTo().defaultContent();
            }
        }catch (Exception ignored) {}
        return result;
    }
    public static int docusign_frame_detector(String xpath) {
        int result = 0;
        try {
            int frames = frames_calculator();
            System.out.println("Total frames: "+frames);
            for (int i = 0; i < frames; ++i) {
            	driver.switchTo().defaultContent();
                driver.switchTo().frame(i);
                Thread.sleep(3000);
                    try {
                        Wait.off_implicit_wait();
                        if ( elem(xpath).isDisplayed()) {
                            return i;
                        }
                        Wait.on_implicit_wait();
                    } catch (Exception ignored) {}
                driver.switchTo().defaultContent();
            }
        }catch (Exception ignored) {}
        return result;
    }

    public static int frames_calculator() {
        int result = 0;
        try {
            int last_value = 0;
            int attempts = 0;
            for (int i = 0; i < 100 && attempts < 40; ++i) {
                int current_value = driver.findElements(By.tagName("iframe")).size();
                if (current_value > 0) {
                    if (last_value == current_value) {
                        ++attempts;
                    } else {
                        attempts = 0;
                    }
                    last_value = current_value;
                    result = current_value;
                }
                Thread.sleep(100);
            }
        } catch (Exception ignored){}
        return result;
    }
}
