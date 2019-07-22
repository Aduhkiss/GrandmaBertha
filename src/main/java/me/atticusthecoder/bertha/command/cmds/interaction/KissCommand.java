package me.atticusthecoder.bertha.command.cmds.interaction;

import java.awt.Color;
import java.util.List;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.InsufficientPermissionException;

public class KissCommand extends Command {
	
	public KissCommand() {
		super("kiss", "Kiss someone!");

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
		
		try {
			event.getMessage().delete().complete();
		} catch(InsufficientPermissionException ex) {
			EmbedBuilder builder = new EmbedBuilder();
			builder.setTitle("Oh no! Something bad happened.");
			builder.setColor(Color.RED);
			builder.appendDescription("I was unable to complete the given action! Error: " + ex.getMessage());
			event.getChannel().sendMessage(builder.build()).queue();
			return;
		}
		
		embed.addField(event.getAuthor().getName() + " kissed " + targets.get(0).getEffectiveName() + "!", "", true);
		
		embed.setColor(Color.PINK);
		
		event.getChannel().sendMessage(embed.build()).queue();
	}

}
