package commands;

import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class satan implements commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        String m;
        String stan = "stan#2205";
        for(int i = 0; i < event.getTextChannel().getMembers().size(); i++) {
            if (stan.equals(event.getJDA().getUsers().get(i).getName().toLowerCase() + "#" + event.getJDA().getUsers().get(i).getDiscriminator())) {
                m = event.getJDA().getUsers().get(i).getAsMention();
                event.getTextChannel().sendMessage(m).queue();
                stan = "";
                break;
            }
        }
        if(stan.equals("stan#2205")) {
            event.getTextChannel().sendMessage("Sorry but there is no Satan to bully.").queue();
        }
    }

    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
