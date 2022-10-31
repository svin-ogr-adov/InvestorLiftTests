package Main;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;
import java.util.concurrent.CompletableFuture;

import javax.mail.MessagingException;

import org.testng.annotations.Test;

import Data.Emails;
//import Modules.Stage.S_Open_House;
import Mail.Check;
import Mail.Mail_Info;
import Mail.Sender;
import Modules.Stage.S_Login;
import Potroha.All_Tabs_Close;
import Potroha.Collector;
import Potroha.Driver;
import Potroha.Logger;
import Potroha.User_Info;
import Scripts.Contract_Sign;

//class SmtpAuthenticator extends Authenticator {
//	private String user = null;
//	private String pwd  = null;
//
//	public SmtpAuthenticator(String user, String pwd) {
//		this.user = user;
//		this.pwd = pwd;
//	}
//
//	protected PasswordAuthentication getPasswordAuthentication() {
//		return new PasswordAuthentication(this.user, this.pwd);
//	}
//}

public class All_Tests {

//	@Test
//	void ghj() throws UnsupportedEncodingException {
//		Sender.sender(Emails.address_1.host,
//			 Emails.address_1.user,
//			 Emails.address_1.password);
//	}
//	public static void sendGMX() throws MessagingException{
//
//	try {
//		String user = "svinograd@gmx.com";
//		String password = "bRM81nMw4t";
//		String host = "mail.gmx.com";
//
//		//Prepare session
//		Properties properties = System.getProperties();
//		//properties = new Properties();
//	    properties.put("incomingHost", "imap.gmx.com");
//	    properties.put("mail.store.protocol", "imap");
//	    properties.put("mail.transport.protocol", "smtp");
//	    properties.put("mail.smtp.host", "mail.gmx.com");
//	    properties.put("mail.smtp.port", "587");
//	    properties.put("mail.smtp.auth", "true");
//	    properties.put("mail.smtp.user", user);
//	    properties.put("mail.smtp.password", password);
//	    properties.put("mail.smtp.starttls.enable", "true");
//
//		//SmtpAuthenticator auth = new SmtpAuthenticator(user, password);
//		Session session = Session.getDefaultInstance(properties);
//		session.setDebug(true);
//
//		//Prepare message
//		Address from = new InternetAddress("svinograd@gmx.com", "Stefan Prange");
//		Address to = new InternetAddress("x5y530y@gmail.com");
//		MimeMessage message = new MimeMessage(session);
//		message.setFrom(from);
//		message.setRecipient(Message.RecipientType.TO, to);
//		message.setSentDate(new Date());
//		message.setSubject("This is the test mail's subject.");
//		message.setText("This is the test mail's content.");
//		message.saveChanges();
//
//		//Send message
//		Transport transport = session.getTransport("smtp");
//		transport.connect(host, 587, user, password);
//		transport.sendMessage(message, message.getAllRecipients());
//		transport.close();
//
//	} catch (UnsupportedEncodingException e) {
//		e.printStackTrace();
//		return;
//	} catch (NoSuchProviderException e) {
//		e.printStackTrace();
//		return;
//	} catch (MessagingException e) {
//		e.printStackTrace();
//		return;
//	}
//	}

	@Test
    public static void Mail_Notifications() throws InterruptedException, MessagingException, IOException {

//        Calendar start_time = Calendar.getInstance();
//        System.setProperty("webdriver.chrome.driver","/Users/svinograd/tools/chromedriver/chromedriver");
//        new Driver();
//        new Collector();
//        new User_Info();

//		Check.print_mails(Check.get_emails(Emails.address_1.host,
//                						   Emails.address_1.user,
//                						   Emails.address_1.password,
//                						   "INBOX"));

//		Sender.sender("smtp.yandex.com",
//				 "svinotest@ya.ru",
//				 Emails.address_1.password);
//		Sender.sender(Emails.address_2.host,
//				 Emails.address_2.user,
//				 Emails.address_2.password);
	       CompletableFuture.runAsync(() -> {
	            try {
	                Check.clean_email_folder(Emails.address_1.host, Emails.address_1.user,
	                		Emails.address_1.password, "INBOX");
	            } catch (MessagingException e) {
	                throw new RuntimeException(e);
	            }
	        });

        //-------------------------------------------------------------------------

//        S_Login.s_login();
//        Contract_Sign.contract_sign(Data.Users.User_Test_ID);
//        //S_Open_House.s_open_house();
//
//        //--------------------------------------------------------------------------
//
//        Thread.sleep(5000);
//        Vector<Mail_Info> l = Check.get_emails(Emails.address_1.host,
//        								 Emails.address_1.user,
//        								 Emails.address_1.password,
//        								 "INBOX");
//        Check.compare_results(Collector.sent_events,l);
//        All_Tabs_Close.all_tabs_close();
//        Driver.driver.quit();
//        Thread.sleep(10000);
//        Collector.inf += Logger.total_test_time(start_time, Calendar.getInstance());
//        Sender.sender(Emails.address_1.host,
//				 	  Emails.address_1.user,
//				 	  Emails.address_1.password);
//        new File(System.getProperty("user.dir")+"/contract.pdf").delete();
    }
}
