package me.atticusthecoder.bertha.command.cmds.interaction;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.InsufficientPermissionException;

public class HugCommand extends Command {
	
	public String[] images = {
			"TO",
			"BE",
			"ADDED",
			"sometime else cause im too lazy"
			};
	
	public HugCommand() {
		super("hug", "Hug someone!");

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
		
		embed.addField(event.getAuthor().getName() + " hugged " + targets.get(0).getEffectiveName() + "!", "", true);
		embed.setColor(Color.GREEN);
		
		event.getChannel().sendMessage(embed.build()).queue();
	}
	
	public String getRandomImage() {
		Random r = new Random();
		int i = r.nextInt(images.length);
		return images[i];
	}

}
