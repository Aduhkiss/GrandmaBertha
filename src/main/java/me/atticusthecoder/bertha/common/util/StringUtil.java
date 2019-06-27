package me.atticusthecoder.bertha.common.util;

import java.util.regex.Pattern;

public class StringUtil {
	public static String[] convertToArray(String string) {
		Pattern pattern = Pattern.compile(" ");
		String[] arr = pattern.split(string);
		return arr;
	}
}
