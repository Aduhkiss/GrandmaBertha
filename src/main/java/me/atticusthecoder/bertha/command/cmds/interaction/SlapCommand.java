package me.atticusthecoder.bertha.command.cmds.interaction;

import java.awt.Color;
import java.util.List;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class SlapCommand extends Command {
	
	public SlapCommand() {
		super("slap", "Slap someone!");

	}

	@Override
	public void execute(MessageReceivedEvent event) {
		List<Member> targets = event.getMessage().getMentionedMembers();
		
		if(targets.isEmpty()) {
			event.getChannel().sendMessage("You need to mention someone!").queue();
			return;
		}
		
		if(targets.size() > 1) {
			event.getChannel().sendMessage("You can only mention 1 user!").queue();
			return;
		}
		
		EmbedBuilder embed = new EmbedBuilder();
		event.getMessage().delete().complete();
		
		embed.addField(event.getAuthor().getName() + " slapped " + targets.get(0).getEffectiveName() + "!", "", true);
		embed.setColor(Color.RED);
		
		event.getChannel().sendMessage(embed.build()).queue();
	}

}