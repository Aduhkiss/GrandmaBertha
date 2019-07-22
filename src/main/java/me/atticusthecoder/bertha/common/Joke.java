package me.atticusthecoder.bertha.common;

public class Joke {
	
	String theJoke;
	String punchline;
	
	public Joke(String theJoke, String punchline) {
		this.theJoke = theJoke;
		this.punchline = punchline;
	}
	
	public String getJoke() {
		return theJoke;
	}
	
	public String getPunchline() {
		return punchline;
	}

}
