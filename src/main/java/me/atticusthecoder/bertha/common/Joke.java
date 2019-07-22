package me.atticusthecoder.bertha.common;

public class Joke {
	
	String theJoke;
	String punchline;
	String submitter;
	
	public Joke(String theJoke, String punchline, String submitter) {
		this.theJoke = theJoke;
		this.punchline = punchline;
		this.submitter = submitter;
	}
	
	public String getJoke() {
		return theJoke;
	}
	
	public String getPunchline() {
		return punchline;
	}
	
	public String getSubmitter() {
		return submitter;
	}

}
