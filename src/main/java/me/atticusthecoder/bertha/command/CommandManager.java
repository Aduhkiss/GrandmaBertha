package me.atticusthecoder.bertha.command;

import java.util.ArrayList;
import java.util.List;

import me.atticusthecoder.bertha.command.cmds.fun.CoinflipCommand;
import me.atticusthecoder.bertha.command.cmds.fun.EightBallCommand;
import me.atticusthecoder.bertha.command.cmds.fun.JokeCommand;
import me.atticusthecoder.bertha.command.cmds.hypixel.HypixelGuildCommand;
import me.atticusthecoder.bertha.command.cmds.hypixel.HypixelLeaderboardCommand;
import me.atticusthecoder.bertha.command.cmds.hypixel.HypixelPlayerCommand;
import me.atticusthecoder.bertha.command.cmds.information.AboutCommand;
import me.atticusthecoder.bertha.command.cmds.information.HelpCommand;
import me.atticusthecoder.bertha.command.cmds.information.MusicHelpCommand;
import me.atticusthecoder.bertha.command.cmds.interaction.HugCommand;
import me.atticusthecoder.bertha.command.cmds.interaction.KissCommand;
import me.atticusthecoder.bertha.command.cmds.interaction.SlapCommand;
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
			
			// Information Commands
			commands.add(new HelpCommand());
			commands.add(new MusicHelpCommand());
			commands.add(new AboutCommand());
			
			// Fun Commands
			commands.add(new EightBallCommand());
			commands.add(new CoinflipCommand());
			commands.add(new JokeCommand());
			
			// Interaction Commands
			commands.add(new HugCommand());
			commands.add(new KissCommand());
			commands.add(new SlapCommand());
			
			// Hypixel Commands
			commands.add(new HypixelPlayerCommand());
			commands.add(new HypixelGuildCommand());
			commands.add(new HypixelLeaderboardCommand());
		});
	}
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		Multithreading.runAsync(() -> {
			for(Command cmd : commands) {
				if(event.getMessage().getContentRaw().startsWith(PREFIX + cmd.getName())) {
					cmd.execute(event);
					// Log the execution of this command
				}
			}
		});
	}

}
