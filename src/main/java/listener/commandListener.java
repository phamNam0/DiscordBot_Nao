package listener;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;
import core.*;

public class commandListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().startsWith(STATIC.PREFIX) &&
                event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {

            commandHandler.handleCommands(commandHandler.parse.parser(event.getMessage().getContentRaw().toLowerCase(), event));

        }
    }
}
