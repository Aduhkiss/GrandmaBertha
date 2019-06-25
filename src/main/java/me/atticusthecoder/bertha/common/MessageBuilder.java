package me.atticusthecoder.bertha.common;

import java.util.ArrayList;
import java.util.List;

import net.dv8tion.jda.core.entities.User;

public class MessageBuilder {
	
	private List<String> payload = new ArrayList<String>();
	
	public MessageBuilder() {
	}
	
	public void addText(String text) {
		payload.add(text);
	}
	
	public void send(User user) {
        // openPrivateChannel provides a RestAction<PrivateChannel>
        // which means it supplies you with the resulting channel
        user.openPrivateChannel().queue((channel) ->
        {
            //channel.sendMessage(getEmbed()).queue();
            for(String line : payload) {
            	channel.sendMessage(line).queue();
            }
        });
	}
}
