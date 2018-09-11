package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface commands {

    boolean called(String[] args, MessageReceivedEvent event);

    void action(String[] args, MessageReceivedEvent event);

    void executed(boolean args, MessageReceivedEvent event);

    String help();
}
