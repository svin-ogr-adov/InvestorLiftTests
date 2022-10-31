package Mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import Data.Contract;
import Potroha.Collector;
import Potroha.User_Info;

public class Sender {

    public static void sender(String host,
			                  String user,
			                  String password) throws UnsupportedEncodingException {

    	try {
    		Properties properties = System.getProperties();
    	    properties.put("incomingHost", host);
    	    properties.put("mail.store.protocol", "imap");
    	    properties.put("mail.transport.protocol", "smtp");
    	    properties.put("mail.smtp.host", host);
    	    properties.put("mail.smtp.port", "587");
    	    properties.put("mail.smtp.auth", "true");
    	    properties.put("mail.smtp.user", user);
    	    properties.put("mail.smtp.password", password);
    	    properties.put("mail.smtp.starttls.enable", "true");
    	    Session session = Session.getDefaultInstance(properties);
    		Address from = new InternetAddress(user, "Sergei Vinogradov");
    		Address to = new InternetAddress("x5y530y@gmail.com");
    		MimeMessage message = new MimeMessage(session);
    		message.setFrom(from);
    		message.setRecipient(Message.RecipientType.TO, to);
    		message.setSentDate(new Date());
    		message.setSubject("Test report");
    		BodyPart body_part = new MimeBodyPart();
    		body_part.setText(Collector.header + '\n'+ Collector.inf);
    		Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(body_part);
            File file = new File(Contract.contract);
            if (file.exists()) {
            	body_part = new MimeBodyPart();
                DataSource source = new FileDataSource(Contract.contract);
                body_part.setDataHandler(new DataHandler(source));
                body_part.setFileName(User_Info.info.account +".pdf");
                multipart.addBodyPart(body_part);
            }
            message.setContent(multipart);
    		message.saveChanges();

    		//Send message
    		Transport transport = session.getTransport("smtp");
    		transport.connect(host, 587, user, password);
    		transport.sendMessage(message, message.getAllRecipients());
    		
    		transport.close();

            System.out.println("OK: Mail sent");
        } catch (MessagingException e) {
        	System.out.println("FAIL: Mail sent");
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
    }
}