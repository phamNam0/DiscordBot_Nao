package core;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.ArrayList;

public class commandParser {

    public static commandContainer parser(String raw, MessageReceivedEvent event) {
        String beheaded = raw.replaceFirst(STATIC.PREFIX, "");
        String[] splitbeheaded = beheaded.split(" ");
        String invoke = splitbeheaded[0];
        ArrayList<String> split = new ArrayList<String>();
        for (String s : splitbeheaded) {
            split.add(s);
        }
        String[] args = new String[split.size()-1];
        split.subList(1, split.size()).toArray(args);
        return new commandContainer(raw, beheaded, splitbeheaded, invoke, args, event);
    }

    public static class commandContainer{

        public final String raw;
        public final String beheaded;
        public final String[] splitbeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String raw, String beheaded, String[] splitbeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = raw;
            this.beheaded = beheaded;
            this.splitbeheaded = splitbeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }

    }
}
