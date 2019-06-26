package me.atticusthecoder.bertha;

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
		
		// Check if we have all the required arguments
		if(args == null || args.length == 0) {
			System.out.println("Missing Arguments: <Discord API Key>");
			return;
		}
		
		// Start the bot's code
		grandma = new Grandma(args[0]);
	}
	
	public static Grandma getGrandma() {
		return grandma;
	}
}
