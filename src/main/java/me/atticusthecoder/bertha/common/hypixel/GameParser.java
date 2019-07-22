package me.atticusthecoder.bertha.common.hypixel;

import me.kbrewster.hypixelapi.leaderboards.Leaderboards;

public class GameParser {
	public static Leaderboards getGameFromName(String gameName) {
		if(gameName.equalsIgnoreCase("SG") || gameName.equalsIgnoreCase("SURVIVALGAMES") || gameName.equalsIgnoreCase("SURVIVAL GAMES")) {
			return Leaderboards.SURVIVAL_GAMES;
		}
		if(gameName.equalsIgnoreCase("TNT") || gameName.equalsIgnoreCase("TNT GAMES") || gameName.equalsIgnoreCase("TNTGAMES")) {
			return Leaderboards.TNTGAMES;
		}
		if(gameName.equalsIgnoreCase("QUAKECRAFT") || gameName.equalsIgnoreCase("QUAKE CRAFT")) {
			return Leaderboards.QUAKECRAFT;
		}
		if(gameName.equalsIgnoreCase("SKYWARS") || gameName.equalsIgnoreCase("SKY WARS")) {
			return Leaderboards.SKYWARS;
		}
		if(gameName.equalsIgnoreCase("PROTOTYPE")) {
			return Leaderboards.PROTOTYPE;
		}
		if(gameName.equalsIgnoreCase("VAMPIREZ")) {
			return Leaderboards.VAMPIREZ;
		}
		if(gameName.equalsIgnoreCase("WALLS")) {
			return Leaderboards.WALLS;
		}
		if(gameName.equalsIgnoreCase("SKYCLASH") || gameName.equalsIgnoreCase("SKY CLASH")) {
			return Leaderboards.SKYCLASH;
		}
		if(gameName.equalsIgnoreCase("BW") || gameName.equalsIgnoreCase("BED WARS") || gameName.equalsIgnoreCase("BEDWARS")) {
			return Leaderboards.BEDWARS;
		}
		if(gameName.equalsIgnoreCase("UHC") || gameName.equalsIgnoreCase("ULTRAHARDCORE") || gameName.equalsIgnoreCase("ULTRA HARDCORE")) {
			return Leaderboards.UHC;
		}
		if(gameName.equalsIgnoreCase("PAINTBALL") || gameName.equalsIgnoreCase("PAINT BALL")) {
			return Leaderboards.PAINTBALL;
		}
		if(gameName.equalsIgnoreCase("MM") || gameName.equalsIgnoreCase("MURDERMYSTERY") || gameName.equalsIgnoreCase("MURDER MYSTERY")) {
			return Leaderboards.MURDER_MYSTERY;
		}
		if(gameName.equalsIgnoreCase("SPEEDUHC") || gameName.equalsIgnoreCase("SPEED UHC")) {
			return Leaderboards.SPEED_UHC;
		}
		if(gameName.equalsIgnoreCase("ARCADE")) {
			return Leaderboards.ARCADE;
		}
		if(gameName.equalsIgnoreCase("ARENA")) {
			return Leaderboards.ARENA;
		}
		if(gameName.equalsIgnoreCase("GINGERBREAD")) {
			return Leaderboards.GINGERBREAD;
		}
		//TODO: Add all the games from the Leaderboards class
		// Also use this: https://github.com/KevinPriv/HypixelApi4J/blob/master/src/main/java/me/kbrewster/hypixelapi/leaderboards/Leaderboards.java
		return null;
	}
}

/*

		if(gameName.equalsIgnoreCase("")) {
			return Leaderboards.
		}

*/
