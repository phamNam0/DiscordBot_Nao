package commands;

import core.main;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

public class shutDown implements commands{

public static boolean state = false;

    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentDisplay().equals(STATIC.PREFIX + "bye")&& msg.getAuthor().getIdLong() == STATIC.LONG) {
            event.getTextChannel().sendMessage("Bye " + event.getAuthor().getName()).queue();
            msg.getJDA().shutdown();
        } else {
            event.getTextChannel().sendMessage("You are not my Owner! You can't shut me down.").queue();
        }
    }


    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
