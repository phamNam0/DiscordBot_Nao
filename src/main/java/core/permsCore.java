package core;

import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

import java.util.Arrays;

public class permsCore {
    public static boolean check(MessageReceivedEvent event) {
        if(event.getGuild().getMember(event.getAuthor()).getRoles().size() == 0) {
            event.getTextChannel().sendMessage("You don't have the permission to use that command " +
                    event.getAuthor().getAsMention()).queue();
            return true;
        }
        for(Role r : event.getGuild().getMember(event.getAuthor()).getRoles()) {
            if (Arrays.stream(STATIC.PERMS).parallel().anyMatch(r.getName().toLowerCase()::contains)) return false;

            else
                event.getTextChannel().sendMessage("You don't have the permission to use that command " +
                        event.getAuthor().getAsMention()).queue();
        }
        return true;
    }
}
