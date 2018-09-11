package listener;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class rdyListener extends ListenerAdapter {
    /*public void onReady(ReadyEvent event) {
        for ( Guild g : event.getJDA().getGuilds() ) {
            g.getTextChannels().get(0).sendMessage(
                    "Ready for actions in" + g.getTextChannels().get(0).getAsMention()
            ).queue();
        }
    }*/
}
