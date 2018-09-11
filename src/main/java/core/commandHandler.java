package core;

import commands.commands;
import java.util.HashMap;

public class commandHandler {

    public static final commandParser parse = new commandParser();
    public static HashMap<String, commands> map = new HashMap<String, commands>();

    public static void handleCommands(commandParser.commandContainer cmd) {
        if(map.containsKey(cmd.invoke)) {
            boolean safe = map.get(cmd.invoke).called(cmd.args, cmd.event);

            if(!safe) {
                map.get(cmd.invoke).action(cmd.args, cmd.event);
                map.get(cmd.invoke).executed(safe, cmd.event);
            } else {
                map.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
}
