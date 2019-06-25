package me.atticusthecoder.bertha;

import javax.security.auth.login.LoginException;

import com.google.gson.Gson;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.common.HttpUtil;
import me.atticusthecoder.bertha.common.PresenseData;
import me.atticusthecoder.bertha.extralisteners.MessageLogger;
import me.atticusthecoder.bertha.music.PlayerControl;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Game.GameType;
import net.dv8tion.jda.core.entities.Guild;

public class Grandma {
	private final String APP_ID = "592864986859175936";
	
	// Data
	private int activeServers;
	
	private JDA jda;
	private PresenseData cachedData = null;
	
	public Grandma(String TOKEN) {
		activeServers = 0;
		try {
			CommandManager.get().registerCommands();
			
			jda = new JDABuilder(AccountType.BOT)
					.setToken(TOKEN)
					.addEventListener(CommandManager.get())
					.addEventListener(new MessageLogger())
					.addEventListener(new PlayerControl())
					.build();
			
			System.out.println("Invite Me! " + "https://discordapp.com/oauth2/authorize?client_id=" + APP_ID + "&scope=bot");
			
		} catch (LoginException e) {
			System.out.println("[Grandma Bertha] There was an error while logging into the Discord API!");
		}
		
		// Once the bot is loaded, do some more basic startup stuff
		// Grab a total of how many guilds we are in
		updateGuildCount();
		
		updatePresense();
	}
	
	public void updateGuildCount() {
		activeServers = 0;
		for(Guild server : jda.getGuilds()) {
			activeServers++;
		}
	}
	
	public void updatePresense() {
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Get data from my website, then parse it
				Gson gson = new Gson();
				PresenseData data = gson.fromJson(HttpUtil.get("https://atticusthecoder.github.io/grandma.html"), PresenseData.class);
				
				if(cachedData == null) {
					cachedData = data;
					getJda().getPresence().setGame(Game.of(GameType.valueOf(data.getType()), data.getActivity()));
				}
				
				if(data.getActivity().equals(cachedData.getActivity()) && data.getType().equals(cachedData.getType())) {
					// Its the same data, i dont care
					updatePresense();
				} else {
					cachedData = data;
					getJda().getPresence().setGame(Game.of(GameType.valueOf(data.getType()), data.getActivity()));
				}
				updatePresense();
			}
		};
		t.start();
	}
	
	public int getGuildCount() {
		return activeServers;
	}
	
	public JDA getJda() {
		return jda;
	}
}
