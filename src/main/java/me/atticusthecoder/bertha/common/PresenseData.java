package me.atticusthecoder.bertha.common;

public class PresenseData {
	private String ActivityType;
	private String Activity;
	
	public PresenseData(String ActivityType, String Activity) {
		this.Activity = Activity;
		this.ActivityType = ActivityType;
	}
	
	public String getType() {
		return ActivityType;
	}
	
	public String getActivity() {
		return Activity;
	}
}
