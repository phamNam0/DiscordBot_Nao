package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdHelp implements commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("The following commands exist: \n'satan (We love to bully Satan) " +
                "\n'mention (Use without argument to ping yourself. Use arguments to ping the people)" +
                "\n'avatar (Shows the avatar of yourself or other people in the server) (command is disabled as of now)" +
                "\n'join (Use without argument to let the bot join the VC the user is in. " +
                "Use the Name of the VC as argument to let the bot join the VC" +
                "\n'leave (The bot leaves its current VC" +
                "\n'clear (Needs one Integer as argument. Deletes between 2 and 100 messages")
                .queue();
    }

    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
