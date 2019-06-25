package me.atticusthecoder.bertha.command.cmds.fun;

import java.awt.Color;
import java.util.Random;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CoinflipCommand extends Command {
	
	public CoinflipCommand() {
		super("coinflip", "Flip a coin!");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		Random r = new Random();
		
		int i = r.nextInt(2) + 1;
		
		EmbedBuilder m = new EmbedBuilder();
		m.setTitle("Coin flipped!");
		m.setColor(Color.GREEN);
		
		if(i == 1) {
			m.addField("You flipped a..", "Heads!", true);
		}
		
		if(i == 2) {
			m.addField("You flipped a..", "Tails!", true);
		}
		
		event.getChannel().sendMessage(m.build()).queue();;
		return;
	}
	
	

}
