package me.atticusthecoder.bertha.command.cmds.fun;

import me.atticusthecoder.bertha.Main;
import me.atticusthecoder.bertha.common.Command;
import me.atticusthecoder.bertha.common.Joke;
import me.atticusthecoder.bertha.manager.JokeManager;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class JokeCommand extends Command {

	public JokeCommand() {
		super("joke", "I can tell you a *funny* joke ;)");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		// First we need to generate a joke
		JokeManager jm = Main.getGrandma().jokeManager;
		
		Joke j = jm.getRandomJoke();
		
		Message m = event.getChannel().sendMessage(j.getJoke()).complete();
		
		new Thread() {
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//embed.clear()
				m.editMessage(j.getJoke() + "\n\n" + j.getPunchline());
			}
		}.start();
		
		return;
	}

}
