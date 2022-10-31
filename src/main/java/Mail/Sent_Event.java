package Mail;

import java.util.Calendar;

public class Sent_Event {
        public Sent_Event(String subj) {
                subject = subj;
                fact_send_time = Calendar.getInstance();
        }
        public Sent_Event(String subj, String side) {
                subject = subj;
                contract_side = side;
                fact_send_time = Calendar.getInstance();
        }
        public String subject;
        public Calendar fact_send_time;
        public String contract_side;
}
