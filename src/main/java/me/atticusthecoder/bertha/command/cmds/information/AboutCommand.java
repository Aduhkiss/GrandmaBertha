package me.atticusthecoder.bertha.command.cmds.information;

import java.awt.Color;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class AboutCommand extends Command {
	
	public AboutCommand() {
		super("about", "Shows information about the bot");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		EmbedBuilder e = new EmbedBuilder();
		
		e.setColor(Color.GRAY);
		
		// Then put the actual content
		e.appendDescription("Hello! Welcome to the Grandma Bertha bot, coded by AtticusTheCoder#6362.");
		e.appendDescription("I am a Discord bot that will add all kinds of fun commands into your chatting experience.");
		e.appendDescription("To see a list of my commands, simply do " + CommandManager.get().PREFIX + "help");
		
		//e.appendDescription("Also, I'm open source! You can find my code at `https://github.com/atticusthecoder/GrandmaBertha`");
		
		event.getChannel().sendMessage(e.build()).queue();
	}

}
