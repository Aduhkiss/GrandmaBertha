package me.atticusthecoder.bertha.command.cmds;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MusicHelpCommand extends Command {

	public MusicHelpCommand() {
		super("musichelp", "See all the music commands");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		event.getChannel().sendMessage("Check your DM's!");
		MessageBuilder msg = new MessageBuilder();
		String pre = CommandManager.get().PREFIX;
		
		msg.addText("Music command list:");
		
		msg.addText(pre + "play <Link> = Play a song");
		msg.addText(pre + "join = Joins the Voice Channel");
		msg.addText(pre + "leave = Leave the current voice channel");
		msg.addText(pre + "stop = Stops the current song");
		
		msg.send(event.getAuthor());
	}
}
