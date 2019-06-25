package me.atticusthecoder.bertha.extralisteners;

import me.atticusthecoder.bertha.command.CommandManager;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ChatBot extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
		if(event.getAuthor().isBot()) { return; }
        if (event.isFromType(ChannelType.PRIVATE))
        {
        	boolean unknown = true;
        	if(event.getMessage().getContentRaw().startsWith(CommandManager.get().PREFIX)) { return; }
        	String in = event.getMessage().getContentRaw().toLowerCase();
        	
        	System.out.println("[ChatBot] " + event.getAuthor().getName() + ": " + in);
        	
        	if(in.startsWith("hi") || in.startsWith("hello")) {
        		unknown = false;
        		reply("Hi there!", event.getChannel());
        	}
        	
        	if(in.startsWith("how is it going") || in.startsWith("how are you")) {
        		unknown = false;
        		reply("I'm doing fine! What about you?", event.getChannel());
        	}
        	
        	if(in.startsWith("who are you")) {
        		unknown = false;
        		reply("I am Grandma Bertha! Your new best friend!", event.getChannel());
        	}
        	
        	if(unknown) {
        		System.out.println("[ChatBot] Not replying. Unknown request.");
        		return;
        	}
        }
    }
    
    public void reply(String message, MessageChannel c) {
    	System.out.println("[ChatBot] Replying with " + message);
    	c.sendMessage(message).queue();
    }
}
