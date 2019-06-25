package me.atticusthecoder.bertha;

import javax.security.auth.login.LoginException;

import me.atticusthecoder.bertha.command.CommandManager;
import me.atticusthecoder.bertha.extralisteners.MessageLogger;
import me.atticusthecoder.bertha.music.PlayerControl;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Grandma {
	private final String APP_ID = "592864986859175936";
	
	private boolean SELFBOT = false;
	
	private JDA jda;
	public Grandma(String TOKEN) {
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
	}
	
	public JDA getJda() {
		return jda;
	}
}
