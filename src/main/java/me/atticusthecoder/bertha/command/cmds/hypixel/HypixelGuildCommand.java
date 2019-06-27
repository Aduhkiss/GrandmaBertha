package me.atticusthecoder.bertha.command.cmds.hypixel;

import java.awt.Color;
import java.io.IOException;

import me.atticusthecoder.bertha.Main;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.util.ColorUtil;
import me.atticusthecoder.bertha.common.util.StringUtil;
import me.kbrewster.exceptions.APIException;
import me.kbrewster.hypixelapi.guild.Guild;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HypixelGuildCommand extends Command {
	
	public HypixelGuildCommand() {
		super("hypixelguild", "Display information about a Hypixel Guild");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		if(!Main.getGrandma().hypixelApiEnabled) {
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("The Hypixel API is currently disabled at this time!", "Sorry!", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		String[] args = StringUtil.convertToArray(event.getMessage().getContentRaw());
		
		if(args.length == 1) {
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("You forgot something!", "You need to give the playername you would like to search!", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		String guild = args[1];
		Guild info;
		
		String guildId;
		try {
			guildId = Main.getGrandma().hypixel.getApi().getGuildID(guild);
		} catch (APIException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("There was an error while parsing your request!", "", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		try {
			info = Main.getGrandma().hypixel.getApi().getGuild(guildId);
		} catch (APIException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("There was an error while parsing your request!", "", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		EmbedBuilder builder = new EmbedBuilder();
		
		builder.setColor(ColorUtil.getRandomColor());
		builder.setTitle("Guild info for " + info.getName());
		
		builder.addField("Guild ID", info.getId(), true);
		String tag = "None";
		if(info.getTag() != null) {
			tag = info.getTag();
		}
		builder.addField("Tag", tag, true);
		builder.addField("XP", String.valueOf(info.getCoins()), true);
		builder.addField("Size", String.valueOf(info.getMemberSizeLevel()), true);
		
		event.getChannel().sendMessage(builder.build()).queue();
		return;
	}

}
