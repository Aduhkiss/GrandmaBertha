package me.atticusthecoder.bertha.command.cmds.hypixel;

import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import me.atticusthecoder.bertha.Main;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.hypixel.GameParser;
import me.atticusthecoder.bertha.common.util.ColorUtil;
import me.atticusthecoder.bertha.common.util.StringUtil;
import me.kbrewster.exceptions.APIException;
import me.kbrewster.hypixelapi.leaderboards.Leaderboard;
import me.kbrewster.hypixelapi.leaderboards.Leaderboards;
import me.kbrewster.mojangapi.MojangAPI;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HypixelLeaderboardCommand extends Command {

	public HypixelLeaderboardCommand() {
		super("hypixelleaderboard", "View the given Hypixel Leaderboard");
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
			error.addField("You forgot something!", "You need to specify which game you would like me to show you!", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		String game = args[1];
		//System.out.println("Debug for game: " + game);
		// Find the game that we need to use with the api
		Leaderboards theGame = GameParser.getGameFromName(game);
		
		List<Leaderboard> lb = null;
		
		try {
			lb = Main.getGrandma().hypixel.getApi().getLeaderboard(theGame);
		} catch (APIException | IOException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			EmbedBuilder error = new EmbedBuilder();
			error.setColor(Color.RED);
			error.setTitle("Oops! Something bad happened!");
			error.addField("There was an error while parsing your request!", "", true);
			event.getChannel().sendMessage(error.build()).queue();
			return;
		}
		
		for(Leaderboard board : lb) {
			EmbedBuilder embed = new EmbedBuilder();
			embed.setColor(ColorUtil.getRandomColor());
			embed.setTitle(board.getTitle() + " (" + board.getPrefix() + ")");
			
			for(int i = 0; board.getLeaders().size() > i; i++) {
				UUID uuid = UUID.fromString(board.getLeaders().get(i));
				embed.addField(String.valueOf(i), grabName(uuid), true);
			}
			
			event.getChannel().sendMessage(embed.build()).queue();
		}
		return;
	}
	
	private String grabName(UUID uuid) {
		String theName = null;
		try {
			theName = MojangAPI.getName(uuid);
		} catch(Exception ex) {
			theName = "Err";
		}
		return theName;
	}

}
