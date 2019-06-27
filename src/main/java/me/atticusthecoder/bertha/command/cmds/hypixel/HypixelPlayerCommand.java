package me.atticusthecoder.bertha.command.cmds.hypixel;

import java.awt.Color;
import java.io.IOException;

import me.atticusthecoder.bertha.Main;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.util.ColorUtil;
import me.atticusthecoder.bertha.common.util.StringUtil;

import me.kbrewster.exceptions.APIException;
import me.kbrewster.exceptions.InvalidPlayerException;
import me.kbrewster.hypixelapi.player.HypixelPlayer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HypixelPlayerCommand extends Command {
	
	public HypixelPlayerCommand() {
		super("hypixelplayer", "Get Player stats from Hypixel");
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
		
		// Make sure the user actually put something
		if(args.length == 1) {
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("You forgot something!", "You need to give the playername you would like to search!", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		String player = args[1];
		HypixelPlayer info;
		try {
			info = Main.getGrandma().hypixel.getApi().getPlayer(player);
		} catch (APIException | InvalidPlayerException | IOException e) {
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
		builder.setTitle("Showing stats for " + info.getDisplayname());
		//TODO: Get a random color
		builder.setColor(ColorUtil.getRandomColor());
		String rank = "None";
		if(info.getRank() != null) {
			rank = info.getRank();
		} else {
			rank = info.getCurrentRank();
		}
		
		builder.addField("Rank", rank, true);
		builder.addField("Network Level", String.valueOf(info.getAbsoluteLevel()), true);
		builder.addField("Karma", String.valueOf(info.getKarma()) ,true);
		// There might be something wrong with these data values, if someone could fix them for me
//		builder.addField("First Login", TimeUtil.getMilliToFormatted(info.getFirstLogin()) ,true);
//		builder.addField("Last Login", TimeUtil.getMilliToFormatted(info.getLastLogin()) ,true);
		
		event.getChannel().sendMessage(builder.build()).queue();
		return;
	}
}
