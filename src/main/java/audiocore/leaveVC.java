package audiocore;
import commands.commands;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

import java.awt.*;

public class leaveVC implements commands {
    EmbedBuilder fail = new EmbedBuilder().setColor(Color.RED).setDescription("I am in no Voice Channel");
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        AudioManager aManager = event.getGuild().getAudioManager();
        if(aManager.getConnectedChannel() == null) {
            event.getTextChannel().sendMessage(fail.build()).queue();
            return;
        }
        aManager.closeAudioConnection();

    }

    @Override
    public void executed(boolean args, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
