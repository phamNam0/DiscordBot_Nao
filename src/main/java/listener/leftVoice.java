package listener;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.botDates;

public class leftVoice extends ListenerAdapter {
    private static String name;
    public void onGuildVoiceLeave(GuildVoiceLeaveEvent event) {
        name = event.getVoiceState().getMember().getNickname() == null ? event.getVoiceState().getMember().getEffectiveName() :
                event.getVoiceState().getMember().getNickname();

        event.getGuild().getTextChannelsByName("logger", true).get(0).sendMessage(

                botDates.getDate() + name + " left " + event.getChannelLeft().getName()

        ).queue();
    }
}
