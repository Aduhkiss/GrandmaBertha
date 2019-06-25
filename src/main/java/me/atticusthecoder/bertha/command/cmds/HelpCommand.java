package me.atticusthecoder.bertha.command.cmds;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "See all the commands");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		event.getChannel().sendMessage("Check your DM's!");
		MessageBuilder msg = new MessageBuilder();
		
		msg.addText("My command list:");
		
		for(Command cmd : CommandManager.get().commands) {
			msg.addText(cmd.getName() + " = " + cmd.getDescription());
		}
		
		msg.send(event.getAuthor());
	}
}
