package me.atticusthecoder.bertha.command;

import java.util.ArrayList;
import java.util.List;

import me.atticusthecoder.bertha.command.cmds.HelpCommand;
import me.atticusthecoder.bertha.command.cmds.MusicHelpCommand;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.Multithreading;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandManager extends ListenerAdapter {
	
	public List<Command> commands;
	public final String PREFIX = ";";
	public static CommandManager me;
	
	public static CommandManager get() {
		if(me == null) {
			me = new CommandManager();
		}
		return me;
	}
	
	public void registerCommands() {
		Multithreading.runAsync(() -> {
			// Register commands
			
			commands = new ArrayList<Command>();
			
			// Register commands
			commands.add(new HelpCommand());
			commands.add(new MusicHelpCommand());
		});
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		Multithreading.runAsync(() -> {
			for(Command cmd : commands) {
				if(event.getMessage().getContentRaw().startsWith(PREFIX + cmd.getName())) {
					cmd.execute(event);
				}
			}
		});
	}

}
