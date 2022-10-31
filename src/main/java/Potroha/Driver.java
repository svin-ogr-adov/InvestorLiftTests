package Potroha;

import java.time.Duration;
import java.util.Map;

//import org.apache.commons.exec.OS;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public Driver(){
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("start-maximized");
        //options.addArguments("--disable-extensions");
        //options.addArguments("--auto-open-devtools-for-tabs");

        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://management.brandscience.tech/");
        Map<String, Object> params = Map.of ( "behavior", "allow",
	                						  "downloadPath", System.getProperty("user.dir") );
        driver.executeCdpCommand("Page.setDownloadBehavior", params);
    }
    public static ChromeDriver driver;
}
