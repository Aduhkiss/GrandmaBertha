package me.atticusthecoder.bertha.command.cmds.information;

import java.awt.Color;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HelpCommand extends Command {

	public HelpCommand() {
		super("help", "See all the commands");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		String pre = CommandManager.get().PREFIX;
		event.getChannel().sendMessage("Check your DM's!").queue();
		
		EmbedBuilder m = new EmbedBuilder();
		
		m.setTitle("Command list");
		m.setColor(Color.GREEN);
		
		for(Command cmd : CommandManager.get().commands) {
			m.addField(pre + cmd.getName(), cmd.getDescription(), true);
		}
		
        event.getAuthor().openPrivateChannel().queue((channel) ->
        {
        	channel.sendMessage(m.build()).queue();
        });
	}
}
