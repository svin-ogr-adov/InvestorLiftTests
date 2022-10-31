package Mail;
import static Potroha.Logger.sec_to_min_and_sec;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

import Potroha.Collector;
import Potroha.Logger;

public class Check {

	// case insensetive comparator for strings in strict order
	// "a: b c!" <-> "a^ c" = true, "a: b c!" <-> "c a^" = false
    static public boolean is_contain_string(String where_find, String what_find) {
        String lhs_tmp = where_find.replaceAll("[-+.^:,]","").toLowerCase();
        String rhs_tmp = what_find.replaceAll("[-+.^:,]","").toLowerCase();
        List<String> lhs = Arrays.asList(lhs_tmp.split(" "));
        List<String> rhs = Arrays.asList(rhs_tmp.split(" "));
        int index = 0;
        int quantity = 0;
        for (String r : rhs) {
        	for (; index < lhs.size(); ++index) {
        		if (r.equals(lhs.get(index))) {
        			++quantity;
        			break;
        		}
        	}
        }
        return quantity == rhs.size() ? true : false;
    }


    public static void compare_results(Vector<Sent_Event> s_events, Vector<Mail_Info> m_events) {
        String ok = "";
        String fail = "";
        String result = "";
        String delim = Logger.log_delim.repeat(Logger.log_delim_repeat) + '\n';
        for (Sent_Event sent_event : s_events) {
            for (int i = 0; i < m_events.size(); ++i) {
                if (is_contain_string(s_events.get(i).subject, sent_event.subject)) {
                    ok += delim;
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    ok += "Subject: " + m_events.get(i).subject + '\n';
                    ok += "Sent: " + df.format(m_events.get(i).sent_date) + '\n';
                    ok += "Received: " + df.format(m_events.get(i).receive_date) + '\n';
                    Logger.min_sec fact_delay = sec_to_min_and_sec(ChronoUnit.SECONDS.between(m_events.get(i).sent_date.toInstant(),
                            m_events.get(i).receive_date.toInstant()));
                    Logger.min_sec user_side_delay = sec_to_min_and_sec(ChronoUnit.SECONDS.between(sent_event.fact_send_time.toInstant(),
                            m_events.get(i).receive_date.toInstant()));
                    ok += "Fact delay: " + format_min_and_sec(fact_delay) + '\n';
                    ok += "User side delay: " + format_min_and_sec(user_side_delay) + '\n';
                    s_events.get(i).subject = "";
                    break;
                } else {
                    if (i == m_events.size()-1) {
                        fail += delim;
                        fail += "Not Received: " + sent_event.subject + (sent_event.contract_side != null ? sent_event.contract_side:"") +'\n';
                    }
                }
            }
        }
        if (s_events.size() == m_events.size() && s_events.size() > 0) {
            result +=  delim;
            result += "All " + s_events.size() + " mails was received:\n";
        } else {
            result +=  delim;
            result += m_events.size() + " of " + s_events.size() + " mails was received:\n";
            result += fail;
        }
        result += ok;
        Collector.inf += result;
    }

    public static String format_min_and_sec(Logger.min_sec t) {
        return (t.min > 0 ? t.min + " min " : "")
                + (t.sec > 0 ? t.sec + " sec" : "");
    }


    public static void print_mails(Vector<Mail_Info> i) {
       try {
           for (Mail_Info mail : i) {
               System.out.println("subj: " + mail.subject);
               System.out.println("body: " + mail.body);
               System.out.println("from: " + mail.from);
               System.out.println("sdat: " + mail.sent_date);
               System.out.println("rdat: " + mail.receive_date);
           }
       } catch(Exception ignored) {}

    }

    public static void clean_email_folder(String host, String user, String password, String mail_folder)
            throws MessagingException {
        try {
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "995"); //143
            properties.put("mail.imap.starttls.enable", "true");
            Session email_session = Session.getDefaultInstance(properties);

            // create the imap store object and connect with the server
            Store store = email_session.getStore("imaps");
            store.connect(host, user, password);

            // create the folder object and open it
            Folder folder = store.getFolder(mail_folder);

            folder.open(Folder.READ_WRITE);
            for (Message m : folder.getMessages()) {
                m.setFlag(Flags.Flag.DELETED, true);
            }
            // close the store and folder objects
            folder.close(true);
            store.close();
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }

    }    	
    	
    



    private static String read_message(Message message) {
        String result = "";
        try {
            String body = message.getContentType();
            if (body.contains("multipart")) {
                Multipart multi_part = (Multipart) message.getContent();
                MimeBodyPart part = (MimeBodyPart) multi_part.getBodyPart(0);
                result = part.getContent().toString();
//                                for (int i = 0; i < multi_part.getCount(); ++i) {
//                                        MimeBodyPart part = (MimeBodyPart) multi_part.getBodyPart(i);
//                                        message_content = part.getContent().toString();
//                                }
            } else if (body.contains("text/plain") || body.contains("text/html")) {
                Object content = message.getContent();
                if (content != null) result = content.toString();
            }
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
        return result;
    }

    
    private static String read_mail_from(Message message) {
        String result = "";
        try {
            Address[] fromAddresses = message.getFrom();
            if (fromAddresses != null) {
                result = Arrays.asList(fromAddresses).toString();
            }
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName(), Collector.State.fail);
            Collector.add_event(e.getMessage(), Collector.State.exception);
        }
        return result;
    }

    public static Vector<Mail_Info> get_emails(String host,
    										   String user,
    										   String password,
    										   String mail_folder)
            throws MessagingException, IOException {
    	
    	    Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", "995");
            properties.put("mail.imap.starttls.enable", "true");
            Session email_session = Session.getDefaultInstance(properties);

            // create the imap store object and connect with the server
            Store store = email_session.getStore("imaps");
            store.connect(host, user, password);

            // create the folder object and open it
            Folder email_folder = store.getFolder(mail_folder);
            email_folder.open(Folder.READ_WRITE);

            Vector<Mail_Info> result = new Vector<Mail_Info>();
            for (Message m : email_folder.getMessages()) {
                Mail_Info i = new Mail_Info();
                i.body = read_message(m).trim();
                i.subject = m.getSubject();
                i.from = read_mail_from(m);
                i.sent_date = m.getSentDate();
                i.receive_date = m.getReceivedDate();
                result.add(i);
            }

            // close the store and folder objects
            email_folder.close(false);
            store.close();
            return result;
      }
        
    
    
}