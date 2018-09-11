package listener;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.botDates;


public class joinVoice extends ListenerAdapter {

    public static String name;

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {


        name = event.getVoiceState().getMember().getNickname() == null ? event.getVoiceState().getMember().getEffectiveName() :
                    event.getVoiceState().getMember().getNickname();

        event.getGuild().getTextChannelsByName("logger", true).get(0).sendMessage(

                    botDates.getDate() + name + " joined " + event.getChannelJoined().getName()
        ).queue();

    }

}

