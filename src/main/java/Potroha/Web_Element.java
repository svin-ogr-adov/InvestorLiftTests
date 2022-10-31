package Potroha;

import static Potroha.Driver.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Web_Element {
    public static WebElement elem(String xPath) {
        return driver.findElements(By.xpath(xPath)).get(0);
    }
    public static List<WebElement> elems(String xPath) {
        return driver.findElements(By.xpath(xPath));
    }

    public static WebElement elem_wait(String xPath, int delay, int repeat)
            throws InterruptedException {
        int start_it = repeat;
        int calc_it = repeat;
        Wait.off_implicit_wait();
        WebElement w = null;
        for(;;){
            //System.out.println("iter " + delay);
            if (driver.findElements(By.xpath(xPath)).size() > 0) {
                w = driver.findElements(By.xpath(xPath)).get(0);
                Wait.on_implicit_wait();
                break;
            }
            Thread.sleep(delay);
            --calc_it;
            if (calc_it == 0) {
                System.out.println(xPath + ": Expired! ("+delay+"ms x "+start_it +" iterations)");
                Wait.on_implicit_wait();
                break;
            }
        }
        Wait.on_implicit_wait();
        return w;
    }
}
