package me.atticusthecoder.bertha.command.cmds;

import me.atticusthecoder.bertha.common.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class EightBallCommand extends Command {
	
	public EightBallCommand() {
		super("8ball", "Shake the magic 8 ball");
	}

	@Override
	public void execute(MessageReceivedEvent event) {
		
	}

}
