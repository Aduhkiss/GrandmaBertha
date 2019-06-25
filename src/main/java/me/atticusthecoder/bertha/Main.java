package me.atticusthecoder.bertha;

public class Main {
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
