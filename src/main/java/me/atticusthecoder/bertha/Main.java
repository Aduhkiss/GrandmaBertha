package me.atticusthecoder.bertha;

import me.atticusthecoder.bertha.common.util.StringUtil;

public class Main {
	
	/*
	 * Grandma Bertha Discord Bot
	 * 
	 * Created by Atticus Zambrana
	 * 
	 * A fun Discord bot that has lots of fun commands
	 * and a slightly broken music bot feature lol
	 * but DONT WORRY! ill fix it...later
	 */
	
	private static Grandma grandma;
	public static void main(String[] args) {
		
		boolean DevEnv = false;
		String token = null;
		
		// Take all the arguments, and compile them into one string
		String arg = StringUtil.combine(args, 0);
		
		// Then check if we are going to run the program in dev mode
		if(arg.indexOf("--dev") >=0) {
			DevEnv = true;
		}
		
		if(!DevEnv) {
			// Check if we have all the required arguments
			if(args == null || args.length == 0) {
				System.out.println("Missing Arguments: <Discord API Key>");
				return;
			}
			
			token = args[0];
		} else {
			
			if(args == null || args.length == 0) {
				System.out.println("Missing Arguments: <Discord API Key>");
				return;
			}
			
			token = args[0];
			
			System.out.println("You are running this app in development mode.");
		}
		
		// Start the bot's code
		grandma = new Grandma(token);
	}
	
	public static Grandma getGrandma() {
		return grandma;
	}
}
