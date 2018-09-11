package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdExample implements commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Pong!").queue();
    }

    public void executed(boolean args, MessageReceivedEvent event) {
        System.out.println("cmdExample was executed");
    }

    public String help() {
        return null;
    }
}
