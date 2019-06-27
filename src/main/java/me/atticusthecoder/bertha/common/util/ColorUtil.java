package me.atticusthecoder.bertha.common.util;

import java.awt.Color;
import java.util.Random;

public class ColorUtil {
	public static Color getRandomColor() {
		Random r = new Random();
		int i = r.nextInt(11);
		Color c = Color.WHITE;
		if(i == 0) {
			c = Color.BLACK;
		}
		if(i == 1) {
			c = Color.BLUE;
		}
		if(i == 2) {
			c = Color.CYAN;
		}
		if(i == 3) {
			c = Color.DARK_GRAY;
		}
		if(i == 4) {
			c = Color.GRAY;
		}
		if(i == 5) {
			c = Color.GREEN;
		}
		if(i == 6) {
			c = Color.LIGHT_GRAY;
		}
		if(i == 7) {
			c = Color.MAGENTA;
		}
		if(i == 8) {
			c = Color.ORANGE;
		}
		if(i == 9) {
			c = Color.RED;
		}
		if(i == 10) {
			c = Color.PINK;
		}
		if(i == 11) {
			c = Color.YELLOW;
		}
		return c;
	}
}
