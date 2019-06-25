package me.atticusthecoder.bertha.command.cmds.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EightBallCommand extends Command {
	
	List<String> answers = new ArrayList<String>();
	
	public EightBallCommand() {
		super("8ball", "Shake the magic 8 ball");
		
		// Add the answers to memory
		answers.add("It is certain");
		answers.add("It is decidedly so.");
		answers.add("Yes");
		answers.add("You may rely on it.");
		answers.add("Signs point to yes.");
		answers.add("Outlook good.");
		answers.add("As I see it, yes");
		answers.add("Yes, definitely.");
		answers.add("Without a doubt");
		answers.add("Most likely.");
		
		answers.add("Reply hazy, try again.");
		answers.add("Ask again later.");
		answers.add("Better not tell you now.");
		answers.add("Cannot predict now.");
		answers.add("Concentrate and ask again.");
		
		answers.add("Don't count on it.");
		answers.add("My reply is no.");
		answers.add("My sources say no.");
		answers.add("Outlook not so good.");
		answers.add("Very doubtful.");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		
		Random rand = new Random();
		
		// First pick if its a good answer, middle, or bad
		int a = rand.nextInt(answers.size());
		
		event.getChannel().sendMessage(answers.get(a)).queue();
		return;
	}

}
