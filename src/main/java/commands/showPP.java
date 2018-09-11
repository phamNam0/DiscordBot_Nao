package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.*;

public class showPP implements commands {

    private EmbedBuilder fail = new EmbedBuilder().setColor(Color.RED);

    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {

        if (event.getMessage().getContentDisplay().split(" ").length > 1) {

            String f = "";

            /**1
             * Shows every mentioned users avatar
             */
            if (!event.getMessage().getMentionedUsers().isEmpty() &&

                    event.getMessage().getMentionedUsers().size() ==
                            event.getMessage().getContentDisplay().substring(
                                    event.getMessage().getContentDisplay().indexOf(" "),
                                    event.getMessage().getContentDisplay().length()).length()
                    ) {
                int size = event.getMessage().getMentionedUsers().size();
                for (int i = 0; i < size; i++) {
                    f += event.getMessage().getMentionedUsers().get(i).getAvatarUrl() + "?size=1024" + "\n";
                }


            } else {
                /**
                 * check if a discriminator is given in the arguments.
                 * if it contains one put it in a discriminator namelist.
                 */

                f = event.getMessage().getContentDisplay().substring(
                        event.getMessage().getContentDisplay().indexOf(" "),
                        event.getMessage().getContentDisplay().length()).trim().toLowerCase();
                String[] nameList = f.split(",");
                f = "";

                Map<Integer, String> discriminatorName = new HashMap<>();
                Map<Integer, String> nickOrOnlyEffectiveName = new HashMap<>();
                Map<Integer, String> mentioned = new HashMap<>();
                int doubleocc = 0;
                for (int i = 0; i < nameList.length; i++) {
                    nameList[i] = nameList[i].trim().toLowerCase();
                }
                for (int i = 0; i < nameList.length; i++) {
                    if (mentioned.containsValue(nameList[i])) {
                        doubleocc++;
                    }
                    if (nameList[i].contains("#")) {
                        discriminatorName.put(i, nameList[i]);
                    } else if (nameList[i].contains("@") && nameList[i].indexOf("@") == 0
                            && !mentioned.containsValue(nameList[i])) {
                        mentioned.put(i, nameList[i]);
                    } else {
                        nickOrOnlyEffectiveName.put(i, nameList[i]);
                    }
                }

                /**
                 * get the avatar of the users with discriminator first
                 */

                f = "";
                String tmp = "";
                int mention = 0;
                boolean flag = false;
                String unk = "";
                String tmp2 = "";
                for (int i = 0; i < nameList.length; i++) {
                    for (User l : event.getJDA().getUsers()) {
                        if (discriminatorName.containsKey(i)) {
                            if (discriminatorName.get(i).toLowerCase().equals(l.getName().toLowerCase() + "#"
                                    + l.getDiscriminator())) {
                                if (!f.contains(l.getAvatarUrl() + "?size=1024")) {
                                    f += l.getAvatarUrl() + "?size=1024\n";
                                }
                            }
                        }
                    }
                    for (Member l : event.getTextChannel().getMembers())
                        if (nickOrOnlyEffectiveName.containsKey(i)) {

                            tmp = l.getEffectiveName().toLowerCase();
                            if (tmp.equals(nameList[i])) {
                                if (!f.contains(l.getUser().getAvatarUrl() + "?size=1024\n")) {
                                    f += l.getUser().getAvatarUrl() + "?size=1024\n";
                                }
                            }
                            /**
                             * SEND HELPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP
                             */
                            else if(!l.getEffectiveName().contains(nameList[i])) {

                                flag = true;
                                System.out.println(tmp);
                                System.out.println(nameList[i]);
                                if(!unk.contains(nickOrOnlyEffectiveName.get(i)))
                                //System.out.println(nickOrOnlyEffectiveName.get(i));
                                unk += nickOrOnlyEffectiveName.get(i) + "\n";
                            }

                        }
                    if (mentioned.containsKey(i)) {
                        if (!f.contains(event.getMessage().getMentionedUsers().get(mention).getAvatarUrl() + "?size=1024\n")) {
                            f += event.getMessage().getMentionedUsers().get(mention).getAvatarUrl() + "?size=1024\n";
                        }
                        mention++;
                    }
                }
                System.out.println(flag);
                if (flag) {
                    event.getTextChannel().sendMessage(fail.setDescription("Unknown user was referenced. Please check again following names:\n" + unk).build()).queue();
                }

            }

            if (!f.equals("")) {
                event.getTextChannel().sendMessage(f).queue();
            }

        } else {
            event.getTextChannel().sendMessage(event.getAuthor().getAvatarUrl() + "?size=1024\n").queue();
        }

    }

    public void executed(boolean args, MessageReceivedEvent event) {

    }

    public String help() {
        return null;
    }

}
