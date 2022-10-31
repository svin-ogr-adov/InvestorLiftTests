package Potroha;

import java.util.Vector;

import Mail.Sent_Event;


public class Collector {
    public Collector() {
        sent_events = new Vector<>();
        inf = "";
        header = "";
    }
    public enum State {
        ok, fail, exception
    }
    public static void add_event(String event, State state) {
    	String tmp = state.toString().toUpperCase() + ": " + event;
    	System.out.println(tmp);
        inf += tmp + '\n';
    }
    public static void add_event(Sent_Event event) {
    	sent_events.add(event);
    }

    public static Vector<Sent_Event> sent_events;
    public static String inf;
    public static String header;
}
