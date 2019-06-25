package me.atticusthecoder.bertha.command.cmds.interaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

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
		
		embed.addField(event.getAuthor().getName() + " hugged " + targets.get(0).getEffectiveName() + "!", "", true);
		
		event.getChannel().sendMessage(embed.build()).queue();
	}
	
	public String getRandomImage() {
		Random r = new Random();
		int i = r.nextInt(images.length);
		return images[i];
	}

}
