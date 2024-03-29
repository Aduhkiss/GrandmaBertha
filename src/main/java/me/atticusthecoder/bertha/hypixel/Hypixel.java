package me.atticusthecoder.bertha.hypixel;

import me.atticusthecoder.bertha.common.Module;
import me.kbrewster.hypixelapi.HypixelAPI;

public class Hypixel extends Module {
	
	private HypixelAPI api;
	
	public Hypixel() {
		super("Hypixel API", "Atticus Zambrana");
	}

	@Override
	public void onLoad() {
		// Atticus, you seriously CANNOT FORGET TO REMOVE THIS when uploading to GitHub. seriously

		api = new HypixelAPI("oops");
	}
	
	public HypixelAPI getApi() {
		return api;
	}
	
}
