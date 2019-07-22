package me.atticusthecoder.bertha.common.util;

import java.util.regex.Pattern;

public class StringUtil {
	public static String[] convertToArray(String string) {
		Pattern pattern = Pattern.compile(" ");
		String[] arr = pattern.split(string);
		return arr;
	}
	
	public static String combine(String[] arr, int startPos) {
        StringBuilder str = new StringBuilder();

        for(int i = startPos; i < arr.length; ++i) {
           str = str.append(arr[i] + " ");
        }
        return str.toString();
	}
}
