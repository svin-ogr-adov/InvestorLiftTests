//package Main;
//import static Potroha.All_Tabs_Close.all_tabs_close;
//import static Potroha.Driver.driver;
//import static Potroha.Logger.total_test_time;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Calendar;
//
//import javax.mail.MessagingException;
//
//import Data.Emails;
//import Mail.Sender;
//import Potroha.Collector;
//import Potroha.Driver;
//import Potroha.User_Info;
//
//public class Main {
//
//    public static void main(String[] args) throws MessagingException, IOException, InterruptedException {
//
//        Calendar start_time = Calendar.getInstance();
//        System.setProperty("webdriver.chrome.driver","/Users/svinograd/tools/chromedriver/chromedriver");
//        new Driver();
//        new Collector();
//        new User_Info();
//        //-----------------------------------------------------------------------------------------------
//
//        //All_Tests.Mail_Notifications();
//
//        //-----------------------------------------------------------------------------------------------
//        all_tabs_close();
//        driver.quit();
//        Collector.inf += total_test_time(start_time, Calendar.getInstance());
//        Thread.sleep(5000);
//        Sender.sender(Emails.address_1.host,
//			 	  	  Emails.address_1.user,
//			 	  	  Emails.address_1.password);
//        new File(System.getProperty("user.dir")+"/contract.pdf").delete();
//
//    }
//}
