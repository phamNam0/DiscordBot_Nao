package commands;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class pingBack implements commands {
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        String f;
        if (args.length > 1) {

            if (!event.getMessage().getMentionedUsers().isEmpty()) {
                //for(int i = 0; i < args.length)
                f = event.getMessage().getMentionedUsers().get(0).getAsMention();

            } else {

                f = event.getMessage().getContentDisplay().split(" ")[1].toLowerCase();

                if (f.contains("#")) {
                    String[] list = f.split("#");
                    f = "";
                    f += list[0].toLowerCase() + "#" + list[1];
                }

                boolean status = false;

                for (User l : event.getJDA().getUsers()) {
                    if (f.equals(l.getName().toLowerCase() + "#" + l.getDiscriminator())) {
                        f = l.getAsMention();
                        status = true;
                        break;
                    }
                    if (f.toLowerCase().equals(l.getName().toLowerCase())) {
                        f = l.getAsMention();
                        status = true;
                        break;
                    }
                }
                if (!status && !f.contains("#")) {

                    for (int i = 0; i < event.getTextChannel().getMembers().size(); i++) {
                        String tmp = event.getTextChannel().getMembers().get(i).getNickname() == null ?
                                event.getTextChannel().getMembers().get(i).getEffectiveName().toLowerCase() :
                                event.getTextChannel().getMembers().get(i).getNickname().toLowerCase();
                        if (f.equals(tmp)) {
                            f = event.getTextChannel().getMembers().get(i).getUser().getAsMention();

                        }
                    }

                } else if (!status) {

                    f = "NO ONE WAS FOUND";

                }
            }

            event.getTextChannel().sendMessage(f).queue();

        } else {

            event.getTextChannel().sendMessage(event.getMessage().getAuthor().getAsMention()).queue();

        }
    }

    public void executed(boolean args, MessageReceivedEvent event) {
        System.out.println("pingback was executed");
    }

    public String help() {
        return null;
    }
}
