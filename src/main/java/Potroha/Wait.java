package Potroha;

import static Potroha.Driver.driver;

import java.util.concurrent.TimeUnit;

public class Wait {
    @SuppressWarnings("deprecation")
	public static void off_implicit_wait() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @SuppressWarnings("deprecation")
	public static void on_implicit_wait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
