package me.atticusthecoder.bertha.command.cmds.information;

import java.awt.Color;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.MessageBuilder;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MusicHelpCommand extends Command {

	public MusicHelpCommand() {
		super("musichelp", "See all the music commands");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		String pre = CommandManager.get().PREFIX;
		event.getChannel().sendMessage("Check your DM's!").queue();
		
		EmbedBuilder m = new EmbedBuilder();
		
		m.setTitle("Command list");
		m.setColor(Color.GREEN);
		
		m.addField(pre + "play <Link>", "play a song", true);
		m.addField(pre + "leave", "Leave the voice channel", true);
		m.addField(pre + "stop", "Stops the current song", true);
		m.addField(pre + "skip", "Skips the current song", true);
		m.addField(pre + "pause", "Pauses the song", true);
		m.addField(pre + "volume <Level>", "Change the volume", true);
		m.addField(pre + "restart", "Restart the track", true);
		m.addField(pre + "repeat", "Repeat the song", true);
		m.addField(pre + "reset", "Reset the player", true);
		m.addField(pre + "np", "See what's Now playing", true);
		m.addField(pre + "list", "Show the song queue", true);
		m.addField(pre + "shuffle", "Shuffle the queue", true);
		
        event.getAuthor().openPrivateChannel().queue((channel) ->
        {
        	channel.sendMessage(m.build()).queue();
        });
	}
}
