package commands;

import core.permsCore;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.List;


public class cmdClear implements commands {
    EmbedBuilder erro = new EmbedBuilder().setColor(Color.RED);
    EmbedBuilder suc = new EmbedBuilder().setColor(Color.GREEN);

    private int getInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        if(args.length < 1) {
            event.getTextChannel().sendMessage(
                    erro.setDescription("Enter a number how many messages to delete").build())
                    .queue();
        }
        if(permsCore.check(event))
            return;


        int numb = getInt(args[0]);
        System.out.println(args.length);
        if(numb > 1 && numb <= 100) {
            try {
                MessageHistory history = new MessageHistory(event.getTextChannel());
                List<Message> msg;
                event.getMessage().delete().queue();
                msg = history.retrievePast(numb).complete();
                event.getTextChannel().deleteMessages(msg).queue();
                event.getTextChannel().sendMessage(
                    suc.setDescription("Succesfully deleted " + msg.size() + " messages").build()
                ).queue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            event.getTextChannel().sendMessage(
                    erro.setDescription("Delete messages between 2 and 100").build()
            ).queue();
        }
    }

    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }
}
