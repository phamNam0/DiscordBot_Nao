package listener;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceMoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.botDates;


public class moveVoiceMember extends ListenerAdapter {

    public static String name;

    public void onGuildVoiceMove(GuildVoiceMoveEvent event) {

        name = event.getVoiceState().getMember().getNickname() == null ? event.getVoiceState().getMember().getEffectiveName() :
                event.getVoiceState().getMember().getNickname();

        event.getGuild().getTextChannelsByName("logger",true).get(0).sendMessage(
                botDates.getDate() + name + " left " + event.getChannelLeft().getName() + " and joined " + event.getChannelJoined().getName()
        ).queue();
    }
}
