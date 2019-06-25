package me.atticusthecoder.bertha.common;

import me.atticusthecoder.bertha.command.CommandManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command {
	private String command;
	private String description;
	public Command(String command, String description) {
		this.command = command;
		this.description = description;
		String prefix = CommandManager.get().PREFIX;
		System.out.println("Registered " + prefix + command);
	}
	
	public String getName() {
		return command;
	}
	
	public String getDescription() {
		return description;
	}
	
	public abstract void execute(MessageReceivedEvent event);
}
