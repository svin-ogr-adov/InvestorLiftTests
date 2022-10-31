package Potroha;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import Mail.Mail_Info;

public class Logger {
    public static String log_delim = "-";
    public static int log_delim_repeat = 75;
    static String print_time_with_statement(String statement, Logger.min_sec time){
        return (statement + (time.min > 0 ? time.min+" min ":"")
                + (time.sec > 0 ? time.sec+" sec":""));
    }
    public static void print_delim(String delim, int repeat) {
        System.out.println(delim.repeat(repeat));
    }
    public static String print_delim() {
        return Logger.log_delim.repeat(Logger.log_delim_repeat);
    }
    public static class min_sec {
        min_sec(int minutes, int seconds){
            min = minutes;
            sec = seconds;
        }
        public int min;
        public int sec;
    }
    public static Logger.min_sec sec_to_min_and_sec(long seconds) {
        min_sec result = new min_sec(0,0);
        long min = 0;
        long sec = seconds;
        if (seconds >= 60) {
            min = seconds / 60;
            sec -= min * 60;
        }
        result.min = (int) min;
        result.sec = (int) sec;
        return result;
    }
    public static void received_email(Mail_Info email, Calendar sent_time, Calendar received_time) {
        print_delim();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(" Subject: " + email.subject);
        System.out.println("    Sent: " + dateFormat.format(sent_time.getTime()));
        System.out.println("Received: " + dateFormat.format(received_time.getTime()));
        min_sec t = sec_to_min_and_sec(ChronoUnit.SECONDS.between( sent_time.toInstant(), received_time.toInstant()));
        print_time_with_statement("   Delay: ", t);
    }

    public static String total_test_time(Calendar start_time, Calendar end_time) {
        String result = "";
        result += print_delim()+'\n';
        min_sec t = sec_to_min_and_sec(ChronoUnit.SECONDS.between(start_time.toInstant(), end_time.toInstant()));
        result += print_time_with_statement("Total test time: ", t)+'\n';
        result += print_delim()+'\n';
        return  result;
    }
}
