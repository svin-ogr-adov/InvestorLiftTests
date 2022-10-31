package Potroha;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
   public static String get_date(String delimiter) {
       DateFormat dateFormat = new SimpleDateFormat("dd"+delimiter+"MM"+delimiter+"yyyy");
       return dateFormat.format(Calendar.getInstance().getTime());
   }
}
