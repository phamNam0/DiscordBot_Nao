package audiocore;

import commands.commands;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

import java.awt.*;

public class joinVC implements commands {
    EmbedBuilder fail = new EmbedBuilder().setColor(Color.RED);

    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    /**
     *
     * @param args
     * @param event
     */
    public void action(String[] args, MessageReceivedEvent event) {
        VoiceChannel channel;
        AudioManager aManager = event.getGuild().getAudioManager();
        if(args.length == 0) {
            if(event.getMember().getVoiceState().getChannel() != null) {
                channel = event.getMember().getVoiceState().getChannel();
                aManager.openAudioConnection(channel);
            } else {
                event.getTextChannel().sendMessage(fail.setDescription(event.getAuthor().getAsMention() +
                        ", you are not inside a Voice Channel!").build()).queue();
            }
        } else {
            String ch = event.getMessage().getContentDisplay().split(" ")[1];
            if(event.getGuild().getVoiceChannelsByName(ch,true).size() != 0) {
                channel = event.getGuild().getVoiceChannelsByName(ch, true).get(0);
                aManager.openAudioConnection(channel);
            } else {
                event.getTextChannel().sendMessage(fail.setDescription("The Channel does not exist").build()).queue();
            }
        }
    }

    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
