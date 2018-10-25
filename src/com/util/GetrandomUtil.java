package com.util;

import java.util.Random;

public class GetrandomUtil {
	public String getrandom() {
		String random=String.valueOf(Math.abs(new Random().nextInt()));
		if(random.length()==9) {
			random+="0";
		}
		return random;
	}
}
