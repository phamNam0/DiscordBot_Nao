package core;

import audiocore.joinVC;
import audiocore.leaveVC;
import commands.*;
import listener.*;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import util.STATIC;

import javax.security.auth.login.LoginException;

public class main {

    private static JDABuilder builder;
    public static boolean state;
    public static void main(String[] args) {
        builder = new JDABuilder(AccountType.BOT);
        //token = args[0];
        String token = STATIC.IDTOKEN;
        builder.setToken(token);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Use: 'help for available commands"));

        add();
        command();

        try {
            JDA jda = builder.build().awaitReady();

        } catch (InterruptedException | LoginException e) {
            e.printStackTrace();
        }
    }

    private static void command() {
        commandHandler.map.put("ping", new cmdExample());

        commandHandler.map.put("mention", new pingBack());

        commandHandler.map.put("join", new joinVC());

        commandHandler.map.put("leave", new leaveVC());

        commandHandler.map.put("bye", new shutDown());

        commandHandler.map.put("avatar", new showPP());

        commandHandler.map.put("satan", new satan());

        commandHandler.map.put("help", new cmdHelp());

        commandHandler.map.put("clear", new cmdClear());
    }

    private static void add() {

        builder.addEventListener(new commandListener());

        //builder.addEventListener(new rdyListener());

        builder.addEventListener(new joinVoice());

        builder.addEventListener(new moveVoiceMember());

        builder.addEventListener(new leftVoice());
    }
}
